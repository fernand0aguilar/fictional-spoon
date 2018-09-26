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
var cucumber = require('gulp-cucumber');
var exec = require('child_process')
    .exec;

var process = require('process');

// If the app environment is not set, we default to development
var ENV = process.env.NODE_ENV || 'development';

// Here, we use dotenv  to load our env vars in the .env, into process.env
require('dotenv').load();

// Config modules
var ngConfig = require('gulp-ng-config');
var config = require('./config.js');

/*
 *  We first generate the json file that gulp-ng-config uses as input.
 *  Then we source it into our gulp task.
 *  The env constants will be a saved as a sub-module of our app, ngEnVars.
 *  So we shall name it ngEnvVars.config.
 */
gulp.task('ng-config', function() {
    fs.writeFileSync('./config.json',
        JSON.stringify(config[ENV]));
    gulp.src('./config.json')
        .pipe(
            ngConfig('pinoquio-config', {
                createModule: true
            })
        )
        .pipe(gulp.dest('./app/config/'))
});


gulp.task('accept', function(callback) {
    runSequence(
        'setDB',
        'cucumber',
        function(error) {
            if (error) {
                console.log(error.message);
            } else {
                console.log('TESTES FINALIZADOS');
            }
            callback(error);
        });
})

gulp.task('setDB', function(cb) {
    exec('psql -f ./tests/dump.sql -U aebrh aebrh', function(err, stdout, stderr) {
        console.log("FUNFO");
        console.log(stdout);
        console.log(stderr);
        cb(err);
    });
})

gulp.task('cucumber', function() {

    var file = "*";
    if (process.argv.length >= 4) {
        file = process.argv[3].replace(/-+/, "");
    }

    return gulp.src('./tests/features/' + file)
        .pipe(cucumber({
            'steps': './tests/features/step_definitions/commom_steps.js',
            'support': './tests/features/support/*.js'
        }))
})

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

gulp.task('commit-changes', function() {
    return gulp.src('.')
        .pipe(git.add())
        .pipe(git.commit('[Prerelease] Bumped version number'));
});

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

gulp.task('push-changes', function(cb) {
    git.push('origin', 'master', cb);
});

gulp.task('release', function(callback) {
    runSequence(
        'bump-version',
        //'changelog',
        //'config',
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

gulp.task('finalBuild', ['build', 'sass', 'aeb', 'vendor', 'vendorCss', 'buildHtml', 'fixIndex', 'buildImages', 'buildIcons', 'copy-config']);

gulp.task('start', ['finalBuild', 'watch']);

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

gulp.task('buildIcons', function(done) {
    gulp.src(['./resources/icons/**/*'])
        .pipe(gulp.dest('./resources/dist/icons'))
        .on('end', done);
})

gulp.task('buildHtml', function(done) {
    gulp.src(['./app/**/*.html', './components/**/*.html'])
        .pipe(replace('resources/img/', 'img/'))
        .pipe(replace(/app\/([a-z]*\/)/g, 'html/$1'))
        .pipe(gulp.dest('./resources/dist/html'))
        .on('end', done);
});

gulp.task('buildImages', function(done) {
    gulp.src(['./resources/img/**/*'])
        .pipe(gulp.dest('./resources/dist/img'))
        .on('end', done);
})


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


gulp.task('vendor', function() {
    return gulp.src(
            [
                './bower_components/angular/angular.js',
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
                './libs/jquery.ptTimeSelect/src/jquery.ptTimeSelect.js',
                './bower_components/cryptojslib/rollups/aes.js',
                './bower_components/cryptojslib/rollups/sha256.js',
                './bower_components/angular-validation-match/dist/angular-validation-match.min.js',
                './bower_components/angular-local-storage/dist/angular-local-storage.min.js',
                './bower_components/Chart.js/Chart.min.js',
                './bower_components/fingerprintjs2/dist/fingerprint2.min.js',
                './bower_components/aeb-filter/dist/aeb-filter.min.js',
                './bower_components/aeb-directive/dist/aeb-directive.min.js',
                './bower_components/aeb-conector/dist/aeb-conector.min.js',
                './bower_components/angular-chart.js/dist/angular-chart.min.js',
                './bower_components/angular-dropzone/lib/angular-dropzone.js',
                './bower_components/angular-ui-uploader/dist/uploader.min.js',
                './bower_components/dropzone/downloads/dropzone.min.js',
                './bower_components/sweetalert/dist/sweetalert.min.js',
                './bower_components/angular-sweetalert/SweetAlert.min.js'
            ])
        .pipe(gulp.dest('./resources/dist'));
});

gulp.task('vendorCss', function() {
    return gulp.src([
            './bower_components/angular-material/angular-material.min.css',
            './resources/fonts/robotoRegular/roboto_regular.css',
            './bower_components/jquery-ui/themes/redmond/jquery-ui.min.css',
            './bower_components/sweetalert/dist/sweetalert.css',
            './libs/jquery.ptTimeSelect/src/jquery.ptTimeSelect.css'
        ])
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

gulp.task('fixIndex', function(done) {
    var version = getPackageJsonVersion();
    gulp.src(['./index.html'])
        .pipe(replace('resources/dist/', ''))
        .pipe(replace('resources/icons/', 'icons/'))
        .pipe(replace('resources/img/', 'img/'))
        .pipe(replace('app.js', 'app.js?version=' + version))
        .pipe(replace('app.min.js', 'app.min.js?version=' + version))
        .pipe(replace('app/config/config.js', 'config.js?version=' + version))
        .pipe(replace('aeb.js', 'aeb.js?version=' + version))
        .pipe(removeCode({
            production: true
        }))
        .pipe(gulp.dest('./resources/dist'))
        .on('end', done)
});

gulp.task('build', [], function() {
    return gulp.src(
            [
                './components/**/*.js',
                './app/common/controllers/**/*.js',
                './app/admin/controllers/**/*.js',
                './app/**/*.js',
                './app/admin/components/*.js',
                './app/admin/components/**/*.js'
            ])
        .pipe(concat('app.min.js'))
        .pipe(replace(/app\/(.+?(?!=abc\/))\/templates\//g, 'html/$1/templates/'))
        .pipe(replace('resources/img/', "img/"))
        .pipe(replace('components/', 'html/'))
        .pipe(sourcemaps.init())
        .pipe(concat('app.min.js'))
        .pipe(ngAnnotate())
        .pipe(uglify())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest('./resources/dist'));
});

/**
 * Copia os arquivos base para a pasta resources/dist
 */
gulp.task('copy-config', ['ng-config', 'build'], function() {
    return gulp.src(
            [
                './app.js',
                './app/config/config.js'
            ])
        .pipe(gulp.dest('./resources/dist'));
});


gulp.task('ngdocs', [], function() {
    return gulp.src('./app/**/*.js')
        .pipe(gulpDocs.process())
        .pipe(gulp.dest('./docs'));
});

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

gulp.task('watch', function() {
    gulp.watch('resources/sass/**/*.scss', ['sass']);
    gulp.watch(['./app.js', './app/config/config.js', './components/**/*.js',
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
