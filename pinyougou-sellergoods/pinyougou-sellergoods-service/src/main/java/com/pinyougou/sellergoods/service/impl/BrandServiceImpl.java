package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.mapper.BrandMapper;
import com.pinyougou.pojo.Brand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
*  @Description 品牌服务接口实现类
*  @author Mr.White
*  @date 2018/6/13 0:48
*/
@Service(interfaceName = "com.pinyougou.sellergoods.service.BrandService")
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        //开始分页
        PageInfo<Brand> pageInfo = PageHelper.startPage(1, 10)
                .doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                brandMapper.selectAll();
            }
        });
        System.out.println("总记录数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        return pageInfo.getList();
    }

    /**
     * 分页查询品牌列表
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult findByPage(Brand brand,int page, int rows) {
        try {
            PageInfo<Brand> pageInfo = PageHelper.startPage(page, rows)
                    .doSelectPageInfo(new ISelect() {
                        @Override
                        public void doSelect() {
                            brandMapper.findAll(brand);
                        }
                    });
            return new PageResult(pageInfo.getTotal(),pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //添加品牌
    @Override
    public void saveBrand(Brand brand) {
        try {
            //选择性添加
            brandMapper.insertSelective(brand);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //修改品牌
    @Override
    public void updateBrand(Brand brand) {
        try {
            //选择性修改
            brandMapper.updateByPrimaryKeySelective(brand);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //删除品牌
    @Override
    public void deleteBrand(Long[] ids) {
        try {
            //
            brandMapper.deleteAll(ids);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //查询所有品牌(id与name)
    @Override
    public List<Map<String, Object>> findAllByIdAndName() {
        try {
            //
            return brandMapper.findBrandByIdAndName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
