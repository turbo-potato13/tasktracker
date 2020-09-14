angular.module('app').controller('commentController', function ($scope, $http, $routeParams) {
    const contextPath = 'http://localhost:8190/tasktracker';
    $scope.id = $routeParams["taskId"]

    fillTable = function () {
        $http.get(contextPath + '/api/v1/comment/' + $scope.id)
            .then(function (response) {
                $scope.CommentList = response.data;
            });
    };

    $scope.submitCreateNewComment = function () {
        $http({
            method: 'POST',
            url: contextPath + '/api/v1/comment',
            data: {
                content: $scope.newComment.content,
                task: $scope.id
            }
        }).then(function (response) {
            $scope.CommentList.push(response.data);
        });
    };
    fillTable();
});