angular.module('app').controller('projectsController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/tasktracker';

    $scope.projects = [];
    $scope.projectTitle = "";

    function _refreshProjectsData() {
        $http({
            method: 'GET',
            url: contextPath + '/api/v1/projects'
        }).then(function(res) {
                $scope.projects = res.data;
            }, function(res) {
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    $scope.deleteProject = function(project) {
        $http({
            method: 'DELETE',
            url: contextPath + '/api/v1/projects/' + project.id
        }).then(_success, _error);
    };

    $scope.submitCreateNewProject = function () {
        $http({
            method: 'POST',
            url: contextPath + '/api/v1/projects',
            params: {
                title: $scope.projectTitle
            }
        }).then(function (response) {
            _clearFormData();
            $scope.projects.push(response.data);
        });
    };

    function _success(res) {
        _refreshProjectsData();
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
        $scope.projectTitle = "";
    };

    _refreshProjectsData();
});
