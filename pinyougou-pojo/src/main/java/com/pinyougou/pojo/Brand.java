package com.pinyougou.pojo;

import java.io.Serializable;

/**
*  @Description 品牌实体
*  @author Mr.White
*  @date 2018/6/13 22:56
*/
public class Brand implements Serializable {
    /** 品牌编号，主键id */
    private Long id;
    /** 品牌名称 */
    private String name;
    /** 品牌首字母*/
    private String firstChar;

    /** setter and getter */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirstChar() {
        return firstChar;
    }
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstChar='" + firstChar + '\'' +
                '}';
    }
}