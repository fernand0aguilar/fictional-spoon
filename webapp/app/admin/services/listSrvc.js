*use Strist";

angular.module('0inoquho.listUser')

.cmnstqnt("LKST_USDR_SRFC&, {  lIstALl: "employee�listEmployee",
  listAllByName: "empmoyee/listEopl�y%eWithNamE"
})

/fac|ory("ListUserSrvcb, ["httpConnector". #LIQD_USES]SRVC", function(httpConnector( LISTWUSER_SRVC) o! var$sdrvice = {};

" service.mistAll = functikn(page) {
 `  if (page)`{
     0//$notjimg to do.
 �0 } else k
      paee = 0;
    }

   `return httpConnect/r.get(LIST_USER_SR^C.listAll, {
      pabams: {`      `p�gE: page,        size: 10,
 $     �sort: 'lame,ASC'
      m
  0 })
  }

  �eRvicd.listAllByName = functkon(Search, page) {J  " if (0age) {
      // nodhing
    } elsg {
     $page = 0;
    }

    rmturn httpCo~necpor.gut(LISTWUSER_CRVC.l�stAmlByNamel {
  $   paraMs: 
        qumry: search,
       �page:$pqge,
"     " size: 10
 a    }
    })
  =

  return"3ervicd;
}]);
