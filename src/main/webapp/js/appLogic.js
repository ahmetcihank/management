var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider

        .when("/allbooks", {
            template : 'templates/home.html',
        })
        .when("/newBook", {
            templateUrl :'templates/newEntry.html',
        }).
    when("/Home",{
        templateUrl:'templates/home.html'
    }). when("/managers",{
        templateUrl:'templates/management.html'
    });
});

/*$('.datepicker').datepicker();
$('.datepicker').datepicker({
    format: 'mm/dd/yyyy',
    startDate: '-3d'
});  */
var selectedId =0;
   app.controller('tableCtrl', function($scope, $http,bookService){

       $http({
           method : "GET",
           url : "http://localhost:8383/getAll"

       }).then(function mySuccess(response) {
           $scope.books = response.data;
       }, function myError(response) {
           $scope.books = response.statusText;
   });

       $scope.GetDetails = function (index) {
           var name = $scope.books[index].id;
           //var country = $scope.Customers[index].Country;
           alert("Name: " + name );
       };

       $scope.idSelectedVote = null;
       $scope.selectRow = function (idSelectedVote) {
           $scope.idSelectedVote = idSelectedVote;
           selectedId = idSelectedVote;

       };


       $scope.$watch(function () { return bookService.getBook()    }, function (value) {
           $scope.books = value;
       });

   });


app.controller('myCtrl', function($scope, $http,bookService) {
    var bookName="";
    var author ="";
    var purchaseDate="";

    $scope.saveBook = function () {
        //alert("Hey Bitch0");
        bookName = document.getElementById('bookName').value ;
        author = document.getElementById('author').value;
        purchaseDate = document.getElementById('purchaseDate').value;


        $http({
            method : "GET",
            url : "http://localhost:8383/saveBook",
            params: {'bookName': bookName, 'author': author, 'purchaseDate':purchaseDate },
        }).then(function mySuccess(response) {
            $scope.myWelcome = response.data;
            bookService.addBook(response.data);
            var elmtTable = document.getElementById('mTable');
            var tableRows = elmtTable.getElementsByTagName('tr');
            var rowCount = tableRows.length;

            for (var x=rowCount-1; x>0; x--) {
                elmtTable.deleteRow(x);
            }

            window.setTimeout(function() {
                $(".alert").fadeTo(500, 0).slideUp(500, function(){
                    $(this).remove();
                });
            }, 4000);
        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });

    }



});


app.controller('deleteCtrl', function($scope, $http,bookService) {
    var id="";


    $scope.deleteBook = function () {
        //alert("Hey Bitch0");
      //  bookName = document.getElementById('bookName').value ;
      //  author = document.getElementById('author').value;
      //  purchaseDate = document.getElementById('purchaseDate').value;


        $http({
            method : "GET",
            url : "http://localhost:8383/deletebook",
            params: {'id': selectedId },
        }).then(function mySuccess(response)
        {
            $scope.myWelcome = response.data;
            bookService.addBook(response.data);
            var elmtTable = document.getElementById('mTable');
            var tableRows = elmtTable.getElementsByTagName('tr');
            var rowCount = tableRows.length;

            for (var x=rowCount-1; x>0; x--) {
                elmtTable.deleteRow(x);
            }

            window.setTimeout(function() {
                $(".alert").fadeTo(500, 0).slideUp(500, function(){
                    $(this).remove();
                });
            }, 4000);
        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });



    }

});

app.service('bookService', function() {
    var bookList = [];

    var addBook = function(newlist) {
        bookList = newlist;
    };

    var getBook = function(){
        return bookList;
    };

    return {
        addBook: addBook,
        getBook: getBook,
    };

});



//Management  getmanagers  employeeController



app.controller('managementController', function($scope, $http,employeeService,managerService){
   // var managers ="";
    $http({
        method : "GET",
        url : "http://localhost:8383/getmanagers"

    }).then(function mySuccess(response) {
        $scope.managers = response.data;
        managers = response.data;

    }, function myError(response) {
        $scope.managers = response.statusText;

    });

    $scope.GetDetails = function (index) {
        var name = $scope.books[index].id;
        //var country = $scope.Customers[index].Country;
        alert("Name: " + name );
    };

    $scope.idSelectedVote = null;
    $scope.selectManager = function (idSelectedVote) {
        $scope.idSelectedVote = idSelectedVote;
        selectedId = idSelectedVote;
        employeeService.addEmployee(managers[idSelectedVote-1].employees)
    };

    $scope.$watch(function () { return managerService.getManagers();   }, function (value) {
        $scope.managers = value;
    });


});

app.service('employeeService', function() {
    var employees = [];

    var addEmployee = function(newlist) {
        employees = newlist;
    };

    var getEmployee = function(){
        return employees;
    };

    return {
        addEmployee: addEmployee,
        getEmployee: getEmployee,
    };

});
app.controller('employeeController', function($scope, $http,employeeService){

    $scope.idSelectedVote = null;
    $scope.selectEmployee = function (idSelectedVote) {
        $scope.idSelectedVote = idSelectedVote;
        selectedId = idSelectedVote;

    };

    $scope.$watch(function () { return employeeService.getEmployee();    }, function (value) {
        $scope.employees = value;
    });

});


app.controller('saveManagerController', function($scope, $http,managerService){

    var managerName ="";
    var managerTitle = "";

    $scope.saveManager = function () {

        managerName = document.getElementById('managerName').value;
        managerTitle = document.getElementById('managerTitle').value;


        $http({
            method: "GET",
            url: "http://localhost:8383/saveManagers",
            params: {'managerName': managerName, 'managerTitle': managerTitle},
        }).then(function mySuccess(response) {
            $scope.myWelcome = response.data;
            managerService.addManagers(response.data);
            var elmtTable = document.getElementById('mangerTable');
            var tableRows = elmtTable.getElementsByTagName('tr');
            var rowCount = tableRows.length;

            for (var x = rowCount - 1; x > 0; x--) {
                elmtTable.deleteRow(x);
            }

            window.setTimeout(function () {
                $(".alert").fadeTo(500, 0).slideUp(500, function () {
                    $(this).remove();
                });
            }, 4000);
        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });
    }



});



app.service('managerService', function() {
    var managers = [];

    var addManagers = function(newlist) {
        managers = newlist;
    };

    var getManagers = function(){
        return managers;
    };

    return {
        addManagers: addManagers,
        getManagers: getManagers,
    };
});