angular.module('app').controller('navbarController', function ($scope, $route, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8190/tasktracker';
    vm = this;
    vm.user = {};
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };
    vm.isUserLoggedIn = function () {
        if ($localStorage.currentUser) {
            vm.user.name = $localStorage.currentUser.name;
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
                    vm.user.name = $localStorage.currentUser.name;
                    console.log($localStorage.currentUser);
                    $route.reload();
                }
            }, function errorCallback(response) {
                window.alert(response.data.message);
            });
    };
    vm.logout = function () {
        $localStorage.currentUser = null;
        $http.defaults.headers.common.Authorization = null;
        $route.reload();

    }
})
