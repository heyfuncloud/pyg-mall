package com.pinyougou.sellergoods.service;

import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;

import java.util.List;

/**
*  @Description 品牌服务接口
*  @author Mr.White
*  @date 2018/6/13 0:44
*/
public interface BrandService {

    //查询所有的品牌
    List<Brand> findAll();

    /**
     * 分页查询所有品牌
     * @param page 当前页码
     * @param rows 每页显示的总记录数
     * @return 分页实体
     */
    PageResult findByPage(int page,int rows);

    //添加品牌
    void saveBrand(Brand brand);
    //修改品牌
    void updateBrand(Brand brand);
    //批量删除品牌
    void deleteBrand(Long[] ids);
}
