package com.pinyougou.sellergoods.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
*  @Description 品牌服务接口
*  @author Mr.White
*  @date 2018/6/13 0:44
*/
public interface BrandService {

    //查询所有的品牌
    List<Brand> findAll();

    /**
     * 分页条件查询所有品牌
     * @param page 当前页码
     * @param rows 每页显示的总记录数
     * @return 分页实体
     */
    PageResult findByPage(Brand brand,int page,int rows);

    //添加品牌
    void saveBrand(Brand brand);
    //修改品牌
    void updateBrand(Brand brand);
    //批量删除品牌
    void deleteBrand(Long[] ids);
    /** 定义品牌列表（id与name） */
    List<Map<String,Object>> findAllByIdAndName();
}
