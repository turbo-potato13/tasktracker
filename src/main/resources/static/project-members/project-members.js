angular.module('app').controller('projectsMembersController', function ($scope, $http, $routeParams) {
    const contextPath = 'http://localhost:8190/tasktracker';

    const id = $routeParams["id"]

    $scope.project = {};
    $scope.members = [];

    getProject = function () {
        $http({
            method: 'GET',
            url: contextPath + '/api/v1/projects/' + id
        }).then(function (response) {
            $scope.project = response.data;
            $scope.members = response.data.members;
            console.log("refreshed");
        });
    };

    $scope.submitDeleteMember = function (member) {
        $http({
            method: 'DELETE',
            url: contextPath + '/api/v1/projects/' + id + "/" + member.name
        }).then(getProject());
    };

    $scope.submitAddMember = function () {
        $http({
            method: 'PUT',
            url: contextPath + '/api/v1/projects/' + id + "/" + $scope.login
        }).then(function (response) {
            $scope.members.push(response.data);
        });
    };

    getProject();

});
