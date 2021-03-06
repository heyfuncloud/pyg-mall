package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
*  @Description
*  @author Mr.White
*  @date 2018/6/13 3:06
*/
@RestController
public class BrandController {

    //包扫描需要配置的注解
    @Reference
    private BrandService brandService;

    //查询所有品牌
    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }
}
