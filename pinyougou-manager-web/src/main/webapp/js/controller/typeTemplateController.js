/** 定义控制器层 */
app.controller('typeTemplateController', function($scope, $controller, baseService){

    /** 指定继承baseController */
    $controller('baseController',{$scope:$scope});

    /** 定义搜索对象 */
    $scope.searchEntity = {};
    /** 分页查询 */
    $scope.search = function(page, rows){
        baseService.findByPage("/typeTemplate/findByPage", page, 
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
        baseService.sendPost("/typeTemplate/" + url, $scope.entity)
            .then(function(response){
                if (response.data){
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
       //把品牌json字符串转化成json数组
       $scope.entity.brandIds = JSON.parse(entity.brandIds);
       //把规格json字符串转化成json数组
       $scope.entity.specIds = JSON.parse(entity.specIds);
       //把扩展属性json字符串转化成json数组
       $scope.entity.customAttributeItems = JSON.parse(entity.customAttributeItems);
    };

    /** 批量删除 */
    $scope.delete = function(){
        if ($scope.ids.length > 0){
            baseService.deleteById("/typeTemplate/delete", $scope.ids)
                .then(function(response){
                if (response.data){
                    $scope.reload();
                }else{
                    alert("删除失败！");
                }
            });
        }
    };

    /** 查询所有品牌列表 */
    $scope.findBrandList = function(){
        baseService.sendGet("/brand/findBrandList")
            .then(function (response) {
                //{data:[{id:1,text:'小米'},{id:2,text:'荣耀'},{id:3,text:'华为'}]};
            $scope.brandList = {data:response.data};
        })
    };
    /** 查询所有规格列表 */
    $scope.findSpecList = function () {
        baseService.sendGet("/specification/findSpecList")
            .then(function (response) {
            $scope.specList = {data:response.data};
        })
    };

    /** 定义添加规格选项方法(新增规格选项按钮绑定的点击事件) */
    $scope.addTableRow = function () {
        //网规格选项数组中添加
        $scope.entity.customAttributeItems.push({});
    };
    /** 定义删除一行规格选项方法 */
    $scope.deleteTableRow = function (index) {
        $scope.entity.customAttributeItems.splice(index,1);
    }

});