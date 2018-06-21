/** 定义品牌控制器 */
app.controller('brandController',function ($scope, $controller, baseService) {

    //指定继承baseController
    $controller('baseController',{$scope:$scope});

    //定义json封装查询参数
    $scope.searchEntity = {};

    //分页查询数据
    $scope.search = function (page, rows) {
        //发送异步请求查询数据
        baseService.findByPage("/brand/findByPage",page,rows,$scope.searchEntity)
            .then(function (response) {
            $scope.dataList = response.data.rows;
            //设置总记录数
            $scope.paginationConf.totalItems = response.data.total;
        });
    };
    //添加或修改品牌
    $scope.saveOrUpdate = function () {
        //定义请求URL
        var url = "save";//添加
        if($scope.entity.id){
            url = "update";
        }
        //发送post请求
        baseService.sendPost("/brand/"+url,$scope.entity)
            .then(function (response) {
                if(response.data){
                    //响应成功，重新加载数据
                    $scope.reload();
                    $scope.entity = {};//添加成功后清除entity中的数据
                }else{
                    alert("操作失败！");
                }
            });
    };
    //定义显示修改的方法
    $scope.show = function (entity) {
        // 把entity的json对象转化成一个新的json对象
        $scope.entity = JSON.parse(JSON.stringify(entity));
    };

    //定义删除的方法
    $scope.delete = function () {
        if($scope.ids.length>0){
            //发送异步请求删除 品牌
            baseService.deleteById("/brand/delete",$scope.ids)
                .then(function (response) {
                    if(response.data){
                        $scope.reload();
                    }else{
                        alert("操作失败!");
                    }
                });
        }else{
            alert("请选择要删除的品牌!");
        }
    }
});