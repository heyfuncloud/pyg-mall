package com.pinyougou.mapper;


import com.pinyougou.pojo.Specification;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SpecificationMapper extends Mapper<Specification>{


    /** 多条件查询规格 */
    List<Specification> findAll(@Param("specification") Specification specification);

    /** 查询规格列表 */
    @Select("select id,spec_name as text from tb_specification order by id")
    List<Map<String,Object>> findSpecByIdAndName();
}