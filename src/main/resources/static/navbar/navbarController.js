angular.module('app').controller('navbarController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:8190/tasktracker';
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };
    $scope.isUserLoggedIn = function () {
        if ($localStorage.currentUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.tryToAuth = function (data) {
        console.log(data)
        $http.post(contextPath + '/api/v1/signin', data)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.currentUser = {name: data.name, token: response.data.token};

                    data.email = null;
                    data.password = null;

                    console.log($localStorage.currentUser);
                }
            }, function errorCallback(response) {
                window.alert(response.data.message);
                $scope.clearUser();
            });
    };
})
