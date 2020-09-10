angular.module('app').controller('taskController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/tasktracker';

    fillTable = function () {
        $http.get(contextPath + '/api/v1/task')
            .then(function (response) {
                $scope.TaskList = response.data;
            });
    };

    $scope.submitCreateNewTask = function () {
        $http.put(contextPath + '/api/v1/task', $scope.newTask)
            .then(function (response) {
                $scope.TaskList.push(response.data);
            });
    };

    // $scope.submitOpenPageNewComment = function (id){
    //     $http.get(contextPath + '/api/v1/comment/' + id, $scope.newComment)
    //         .then(function (response){
    //             $scope.CommentList = response.data;
    //         })
    // }

    // $scope.submitCreateNewComment = function () {
    //     $http.post(contextPath + '/api/v1/comment', $scope.newTask)
    //         .then(function (response) {
    //             $scope.TaskList.push(response.data);
    //         });
    // };

    fillTable();
});