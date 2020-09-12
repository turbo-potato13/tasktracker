angular.module('app').controller('taskController', function ($scope, $http,$localStorage) {
    const contextPath = 'http://localhost:8190/tasktracker';

    fillTable = function () {
        $http.get(contextPath + '/api/v1/task')
            .then(function (response) {
                $scope.TaskList = response.data;
            });
    };

    $scope.submitCreateNewTask = function () {
        $http.post(contextPath + '/api/v1/task', $scope.newTask)
            .then(function (response) {
                $scope.TaskList.push(response.data);
            });
    };

    fillTable();
    $scope.isUserLoggedIn = function () {
        if ($localStorage.currentUser) {
            return true;
        } else {
            return false;
        }
    };
});
