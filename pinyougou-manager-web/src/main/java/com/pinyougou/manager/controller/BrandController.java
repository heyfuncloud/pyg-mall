package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PageResult findByPage(@RequestParam("page") Integer page,
                                 @RequestParam("rows") Integer rows){
        return brandService.findByPage(page,rows);
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

}
