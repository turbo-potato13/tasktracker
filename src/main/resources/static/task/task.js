angular.module('app').controller('taskController', function ($scope, $http) {
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

    // $scope.applyFilter = function () {
    //     $http({
    //         url: contextPath + '/api/v1/task',
    //         method: "GET",
    //         params: {book_title: $scope.bookFilter.title}
    //     }).then(function (response) {
    //         $scope.BooksList = response.data;
    //     });
    // }

    fillTable();
});