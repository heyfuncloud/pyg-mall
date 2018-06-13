package com.pinyougou.sellergoods.service;

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

}
