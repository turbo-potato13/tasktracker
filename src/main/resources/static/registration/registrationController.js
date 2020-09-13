angular.module('app').controller('registrationController', function ($scope, $http, $location, $localStorage, toaster) {
    const contextPath = 'http://localhost:8190/tasktracker';

    rc = this;

    rc.register = function (){
        console.log(rc.data)
        $http.post(contextPath + '/api/v1/signup', rc.data)
            .then(function successCallback(response){
                console.log(response)
                toaster.pop('info', 'Вы зарегистрировались','Теперь можете зайти под своим аккаунтом.')
                $('#registrationModal').modal('hide');
                rc.data = null;

            },
                function errorCallback(response){
                    toaster.pop('error', 'Какая-то ошибочка',response.data)
                })
    }
})
