package com.pinyougou.mapper;


import com.pinyougou.pojo.TypeTemplate;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TypeTemplateMapper extends Mapper<TypeTemplate> {

    /** 多条件查询类型模板 */
    List<TypeTemplate> findAll(@Param("typeTemplate") TypeTemplate typeTemplate);
}