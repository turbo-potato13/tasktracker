(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngStorage','toaster', 'ngAnimate'])
        .config(config)
        .run(run);

    function config($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'home/home.html',
                controller: 'homeController'
            })
            .when('/task', {
                templateUrl: 'task/task.html',
                controller: 'taskController'
            })
            .when('/projects', {
                templateUrl: 'project/project.html',
                controller: 'projectsController'
            })
            .when('/project-members/:id', {
                templateUrl: 'project-members/project-members.html',
                controller: 'projectsMembersController'
            })
            .when('/project-tasks/:id', {
                templateUrl: 'task/task.html',
                controller: 'projectsTasksController'
            })
            .when('/comment/:taskId',{
                templateUrl: 'task/comment.html',
                controller: 'commentController'
            });

        // $httpProvider.interceptors.push(function($q, $location) {
        //     return {
        //         'responseError': function(rejection, $localStorage, $http) {
        //             var defer = $q.defer();
        //             if (rejection.status == 401 || rejection.status == 403) {
        //                 console.log('error: 401-403');
        //                 $location.path('/auth');
        //                 delete $localStorage.currentUser;
        //                 $http.defaults.headers.common.Authorization = '';
        //                 // var answer = JSON.parse(rejection.data);
        //                 // window.alert(answer.message);
        //             }
        //             defer.reject(rejection);
        //             return defer.promise;
        //         }
        //     };
        // });
    }

    function run($rootScope, $http, $localStorage) {
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        }
    }
})();
