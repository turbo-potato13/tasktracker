angular.module('app').controller('projectsMembersController', function ($scope, $http, $routeParams) {
    const contextPath = 'http://localhost:8190/tasktracker';
    const id = $routeParams["id"];

    $scope.project = {};
    $scope.email = "";

    function _refreshProjectData() {
        $http({
            method: 'GET',
            url: contextPath + '/api/v1/projects/' + id
        }).then(function(res) {
                $scope.project = res.data;
            }, function(res) {
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    $scope.submitDeleteMember = function (member) {
        $http({
            method: 'DELETE',
            url: contextPath + '/api/v1/projects/' + id + "/" + member.name
        }).then(_success, _error);
    };

    $scope.submitAddMember = function () {
        $http({
            method: 'PUT',
            url: contextPath + '/api/v1/projects/' + id + "/" + $scope.email
        }).then(_success, _error);
    };

    function _success(res) {
        _refreshProjectData();
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
        $scope.email = "";
    };

    _refreshProjectData();

});
