angular.module('app').controller('navbarController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8190/tasktracker';
    vm = this;
    vm.user={};
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };
    vm.isUserLoggedIn = function () {
        if ($localStorage.currentUser) {
            return true;
        } else {
            return false;
        }
    };

    vm.tryToAuth = function (data) {
        console.log(data)
        $http.post(contextPath + '/api/v1/signin', data)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.currentUser = {name: response.data.name, token: response.data.token};

                    data.email = null;
                    data.password = null;
                    vm.user.name = response.data.name;
                    console.log($localStorage.currentUser);
                }
            }, function errorCallback(response) {
                window.alert(response.data.message);
            });
    };
})
