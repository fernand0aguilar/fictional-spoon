var gulp = require('gulp');
var bump = require('gulp-bump');
var git = require('gulp-git');
var gutil = require('gulp-util');
var bower = require('bower');
var concat = require('gulp-concat');
var sass = require('gulp-sass');
var minifyCss = require('gulp-minify-css');
var rename = require('gulp-rename');
var sh = require('shelljs');
var ngAnnotate = require('gulp-ng-annotate');
var notify = require('gulp-notify');
var gulpDocs = require('gulp-ngdocs');
var jshint = require('gulp-jshint');
var sourcemaps = require('gulp-sourcemaps');
var uglify = require('gulp-uglify');
var replace = require('gulp-replace');
var connect = require('gulp-connect');
var removeCode = require('gulp-remove-code');
var fs = require('fs');
var runSequence = require('run-sequence')
    .use(gulp);

// Replace this for the url of the production enviroment
var urlProducao = "http://aebrh.docker.aeb.gov.br";
// replace this for the name of the context for the development application
var contextProducao = "api/";


// changes the version of the tag on bower and package jsons
gulp.task('bump-version', function() {
    var argv = require('minimist')(process.argv.slice(2));
    var version_type = "patch";
    if (argv.type !== undefined) {
        version_type = argv.type;
    }

    return gulp.src(['./bower.json', './package.json'])
        .pipe(bump({
                type: version_type
            })
            .on('error', gutil.log))
        .pipe(gulp.dest('./'));
});

// commit all the uncommitted changes before creating tag
gulp.task('commit-changes', function() {
    return gulp.src('.')
        .pipe(git.add())
        .pipe(git.commit('[Prerelease] Bumped version number'));
});


// creates new git tag based on the bumped version
gulp.task('create-new-tag', function(cb) {
    var version = getPackageJsonVersion();
    git.tag(version, 'Created Tag for version: ' + version, function(error) {
        if (error) {
            return cb(error);
        }
        git.push('origin', 'master', {
            args: '--tags'
        }, cb);
    });
});

// push all the chages to git repository
gulp.task('push-changes', function(cb) {
    git.push('origin', 'master', cb);
});

// starts the entire release process
gulp.task('release', function(callback) {
    runSequence(
        'bump-version',
        'commit-changes',
        'push-changes',
        'create-new-tag',
        function(error) {
            if (error) {
                console.log(error.message);
            } else {
                console.log('RELEASE FINISHED SUCCESSFULLY');
            }
            callback(error);
        });
});

// task that prepares build for moving to productions
gulp.task('finalBuild', ['build', 'sass', 'aeb', 'vendor', 'vendorCss', 'buildHtml', 'fixIndex', 'buildImages', 'buildIcons']);

// starts the scripts for development
gulp.task('start', ['finalBuild', 'watch']);

// compile sass into css
gulp.task('sass', function(done) {
    gulp.src('./resources/sass/style.scss')
        .pipe(sass({
            errLogToConsole: true
        }))
        .pipe(gulp.dest('./resources/dist/css'))
        .pipe(minifyCss({
                keepSpecialComments: 0
            })
            .on('error', onError))
        .pipe(rename({
            extname: '.min.css'
        }))
        .pipe(gulp.dest('./resources/dist/css/'))
        .on('end', done);
});

// compile all the favicos on the application
gulp.task('buildIcons', function(done) {
    gulp.src(['./resources/icons/**/*'])
        .pipe(gulp.dest('./resources/dist/icons'))
        .on('end', done);
})

// changes images references on all the html pages
gulp.task('buildHtml', function(done) {
    gulp.src(['./app/**/*.html', './components/**/*.html'])
        .pipe(replace('resources/img/', 'img/'))
        .pipe(replace(/app\/([a-z]*\/)/g, 'html/$1'))
        .pipe(gulp.dest('./resources/dist/html'))
        .on('end', done);
});

// moves all the images to the dist directory
gulp.task('buildImages', function(done) {
    gulp.src(['./resources/img/**/*'])
        .pipe(gulp.dest('./resources/dist/img'))
        .on('end', done);
})

// build internal dependencies and concatenate them
gulp.task('aeb', function() {
    return gulp.src(
            [
                './bower_components/aeb-filter/dist/aeb-filter.min.js',
                './bower_components/aeb-directive/dist/aeb-directive.min.js',
                './bower_components/aeb-conector/dist/aeb-conector.min.js'
            ])
        .pipe(concat('aeb.js'))
        .pipe(ngAnnotate())
        .pipe(uglify())
        .pipe(gulp.dest('./resources/dist'));
});

// prepares a single vendor file for all the needed dependencies
gulp.task('vendor', function() {
    return gulp.src(
            [
                './bower_components/angular/angular.min.js',
                './bower_components/angular-ui-router/release/angular-ui-router.min.js',
                './bower_components/angular-animate/angular-animate.min.js',
                './bower_components/angular-aria/angular-aria.min.js',
                './bower_components/angular-material/angular-material.min.js',
                './bower_components/jquery/dist/jquery.min.js',
                './bower_components/angular-material-icons/angular-material-icons.min.js',
                './bower_components/moment/min/moment.min.js',
                './bower_components/angular-moment/angular-moment.min.js',
                './bower_components/moment/locale/pt-br.js',
                './bower_components/jquery-ui/jquery-ui.min.js',
                './bower_components/cryptojslib/rollups/aes.js',
                './bower_components/angular-local-storage/dist/angular-local-storage.min.js',
                './bower_components/Chart.js/Chart.min.js',
                './bower_components/fingerprintjs2/dist/fingerprint2.min.js',
                './/bower_components/cryptojslib/components/sha256-min.js',
                './bower_components/angular-chart.js/dist/angular-chart.min.js'
            ])
        .pipe(concat('vendor.js'))
        .pipe(ngAnnotate())
        .pipe(uglify())
        .pipe(gulp.dest('./resources/dist'));
});

// prepare one single vendor css file with all the needed dependencies
gulp.task('vendorCss', function() {
    return gulp.src(
            [
                './bower_components/angular-material/angular-material.min.css'
            ]
        )
        .pipe(concat('vendor.css'))
        .pipe(minifyCss({
                keepSpecialComments: 0
            })
            .on('error', onError))
        .pipe(rename({
            extname: '.min.css'
        }))
        .pipe(gulp.dest('./resources/dist/css'));
});

// fix index so it can work with the new paths, and removed unused code
gulp.task('fixIndex', function(done) {
    var version = getPackageJsonVersion();
    gulp.src(['./index.html'])
        .pipe(replace('resources/dist/', ''))
        .pipe(replace('resources/icons/', 'icons/'))

    .pipe(replace('app.js', 'app.min.js?version=' + version))
        .pipe(removeCode({
            production: true
        }))
        .pipe(gulp.dest('./resources/dist'))
        .on('end', done)
});

// build all the internal files in a single js file
gulp.task('build', function() {
    gulp.src(
            [
                './app.js',
                './appConfig.js',
                './components/**/*.js',
                './app/commom/controllers/**/*.js',
                './app/admin/controllers/**/*.js',
                "./app/**/*.js"
            ])
        .pipe(concat('app.min.js'))
        .pipe(replace(/app\/(.+?(?!=abc\/))\/templates\//g, 'html/$1/templates/'))
        .pipe(replace('resources/img/', "img/"))
        .pipe(replace('components/', 'html/'))
        .pipe(replace(/http:\/\/localhost:8080/g, urlProducao))
        .pipe(replace('aebRh-api/', contextProducao))
        .pipe(sourcemaps.init())
        .pipe(concat('app.min.js'))
        .pipe(ngAnnotate())
        .pipe(uglify())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('./resources/dist'))
})

// creates the documentation based on ng docs anotations
gulp.task('ngdocs', [], function() {
    return gulp.src('./app/**/*.js')
        .pipe(gulpDocs.process())
        .pipe(gulp.dest('./docs'));
});

// run jslint on the entire aplication and creates a report
gulp.task('lint', function() {
    return gulp.src('./app/**/*.js')
        .pipe(jshint({
            browser: true,
            devel: true,
            globals: {
                angular: false,
                $mdDialog: false,
                jsSHA: false,
                CryptoJS: false,
                Chart: false,
                $: false
            },
            strict: "global"
        }))
        .pipe(jshint.reporter('gulp-jshint-html-reporter', {
            filename: './quality/quality.html',
            createMissingFolders: true
        }));
});

// starts to watch changes on multiple files1
gulp.task('watch', function() {
    gulp.watch('resources/sass/**/*.scss', ['sass']);
    gulp.watch(['./app.js', './appConfig.js', './components/**/*.js',
        './app/**/*.js'
    ], ['build']);
    gulp.watch(['app/**/*.html', 'components/**/*.html'], ['buildHtml']);
});

function onError(err) {
    console.log(err);
    this.emit('end');
}

function getPackageJsonVersion() {
    return JSON.parse(fs.readFileSync('./package.json', 'utf8'))
        .version;
};
