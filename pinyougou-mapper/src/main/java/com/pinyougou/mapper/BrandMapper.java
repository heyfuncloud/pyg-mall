package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;

import java.util.List;

/**
*  @Description 品牌数据访问接口
*  @author Mr.White
*  @date 2018/6/13 23:00
*/
public interface BrandMapper {

    List<Brand> findAll();

}
