angular.module('app').controller('projectsController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/tasktracker';

    fillTable = function () {
        $http.get(contextPath + '/api/v1/projects')
            .then(function (response) {
                $scope.projectList = response.data;
            });
    };

    $scope.submitCreateNewProject = function () {
        $http({
            method: 'POST',
            url: contextPath + '/api/v1/projects',
            params: {
                title: $scope.newProject.title
            }
        }).then(function (response) {
            $scope.projectList.push(response.data);
        });
    };

    fillTable();
});
