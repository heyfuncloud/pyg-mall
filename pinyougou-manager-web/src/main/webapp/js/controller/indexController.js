/** 首页控制器层 */
app.controller("indexController",function ($scope, baseService) {
    /** 定义获取登录用户名的方法 */
    $scope.showLoginName = function () {
        baseService.sendGet("/login/username")
            .then(function (response) {
            $scope.loginName = response.data.loginName;
            if(!$scope.loginTime){

                $scope.loginTime = response.data.loginTime;
            }
        })
    }
});