/** 定义基础控制层 */
app.controller('baseController',function ($scope) {

    //定义分页组件需要配置信息对象(json对象)
    $scope.paginationConf = {
        currentPage : 1, //当前页
        totalItems : 100, //总记录数
        itemsPerPage : 10, //每页显示的记录数
        perPageOptions : [5,10,15,20,30], //页码下拉列表框中的options
        onChange : function () { //页码改变事件
            //查询数据
            $scope.reload();
        }

    };
    //重新查询数据
    $scope.reload = function () {
        $scope.search($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    };

    //定义数组封装选中的id
    $scope.ids = [];
    //为CheckBox绑定点击事件
    $scope.updateSelection = function ($event, id) {
        //判断checkbox是否选中,选中 添加到数组中
        if($event.target.checked){
            $scope.ids.push(id);
        }else{ //未选中 从数组中删除
            //获取id在数组中的索引号
            var index = $scope.ids.indexOf(id);
            $scope.ids.splice(index,1);
        }
    };

    /** 根据json字符串数组查询指定key，返回key对应value字符串 */
    $scope.json2Str = function (jsonArr,key) {
        var jsonArr = JSON.parse(jsonArr);
        //定义数组封装最后需要返回的数据
        var res = [];
        for (var i in jsonArr) {
            //取一个json对象
            var json = jsonArr[i];
            //取json对象对应key的值
            var text = json[key];
            res.push(text);
        }
        return res.join(",");
    }
});