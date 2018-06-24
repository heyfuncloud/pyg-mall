/** 定义控制器层 */
app.controller('specificationController', function($scope, $controller, baseService){

    /** 指定继承baseController */
    $controller('baseController',{$scope:$scope});

    /** 定义搜索对象 */
    $scope.searchEntity = {};
    /** 分页查询 */
    $scope.search = function(page, rows){
        baseService.findByPage("/specification/findByPage", page, 
			rows, $scope.searchEntity)
            .then(function(response){
                $scope.dataList = response.data.rows;
                /** 更新总记录数 */
                $scope.paginationConf.totalItems = response.data.total;
            });
    };

    /** 添加或修改 */
    $scope.saveOrUpdate = function(){
        var url = "save";
        if ($scope.entity.id){
            url = "update";
        }
        /** 发送post请求 */
        baseService.sendPost("/specification/" + url, $scope.entity)
            .then(function(response){
                if (response.data){
                    //请求entity
                    $scope.entity = {};
                    /** 重新加载数据 */
                    $scope.reload();
                }else{
                    alert("操作失败！");
                }
            });
    };

    /** 显示修改 */
    $scope.show = function(entity){
        $scope.entity = JSON.parse(JSON.stringify(entity));
        //调用服务层查询规格选项
        baseService.findOne("/specification/findOne",entity.id)
            .then(function (response) {
                $scope.entity.specificationOptions = response.data;
            });
    };

    /** 批量删除 */
    $scope.delete = function(){
        if ($scope.ids.length > 0){
            baseService.deleteById("/specification/delete", $scope.ids)
                .then(function(response){
                    if (response.data){
                        $scope.reload();
                    }else{
                        alert("删除失败！");
                    }
                });
        }
    };

    /** 定义添加规格选项方法(新增规格选项按钮绑定的点击事件) */
    $scope.addTableRow = function () {
        //网规格选项数组中添加
        $scope.entity.specificationOptions.push({});
    };
    /** 定义删除一行规格选项方法 */
    $scope.deleteTableRow = function (index) {
        $scope.entity.specificationOptions.splice(index,1);
    }

});