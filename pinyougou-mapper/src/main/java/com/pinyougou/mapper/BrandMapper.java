package com.pinyougou.mapper;

import com.pinyougou.pojo.Brand;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 品牌数据访问接口
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月1日 下午5:08:25
 * @version 1.0
 */
public interface BrandMapper extends Mapper<Brand> {

    //批量删除品牌
    void deleteAll(@Param("ids") Long[] ids);

    //分页条件查询品牌
    List<Brand> findAll(@Param("brand") Brand brand);

    //查询所有品牌(id与name)
    @Select("select id,name as text from tb_brand order by id")
    List<Map<String,Object>> findBrandByIdAndName();
}