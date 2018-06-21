package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
*  @Description
*  @author Mr.White
*  @date 2018/6/13 3:06
*/
@RestController
@RequestMapping("/brand")
public class BrandController {

    /**
     * 包扫描需要配置的注解：引用服务
     * timeout:调用服务超市的毫秒数
     */
    @Reference(timeout = 10000)
    private BrandService brandService;

    //查询所有品牌
    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }
    //分页查询所有品牌
    @GetMapping("/findByPage")
    public PageResult findByPage(Brand brand,
                                 @RequestParam("page") Integer page,
                                 @RequestParam("rows") Integer rows){
        try {
            //get请求，中文乱码解决
            if(brand!=null && StringUtils.isNoneBlank(brand.getName())){
                brand.setName(new String(brand.getName().getBytes("ISO-8859-1"),"UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandService.findByPage(brand,page,rows);
    }
    //添加品牌
    @PostMapping("/save")
    public boolean save(@RequestBody Brand brand){
        try {
            brandService.saveBrand(brand);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //修改品牌
    @PostMapping("/update")
    public boolean update(@RequestBody Brand brand){
        try {
            brandService.updateBrand(brand);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //删除品牌
    @GetMapping("/delete")
    public boolean delete(Long[] ids){
        try {
            brandService.deleteBrand(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /** 定义品牌列表（id与name） */
    @GetMapping("findBrandList")
    public List<Map<String,Object>> findBrandList(){
        try {
            return brandService.findAllByIdAndName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
