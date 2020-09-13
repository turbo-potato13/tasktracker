angular.module('app').controller('projectsTasksController', function ($scope, $http, $routeParams) {
    const contextPath = 'http://localhost:8190/tasktracker';
    const id = $routeParams["id"];

    $scope.TaskList = [];
    $scope.newTask = {};

    function fillTable() {
        $http({
            method: 'GET',
            url: contextPath + '/api/v1/projects/' + id
        }).then(function(res) {
                $scope.TaskList = res.data.tasks;
            }, function(res) {
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    $scope.submitCreateNewTask = function () {
        $http.put(contextPath + '/api/v1/projects/' + id + "/members", $scope.newTask)
            .then(_success, _error);
    };

    function _success(res) {
        fillTable();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    function _clearFormData() {
        $scope.newTask = {};
    };

    fillTable();

});
