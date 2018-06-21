package com.pinyougou.sellergoods.service.impl;
import com.pinyougou.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.ItemCatMapper;
import com.pinyougou.sellergoods.service.ItemCatService;

import java.util.List;

/**
*  @Description 服务层实现类
*  @author Mr.White
*  @date 2018/6/20 16:25
*/
@Service(interfaceName="com.pinyougou.sellergoods.service.ItemCatService")
@Transactional(readOnly=false)
public class ItemCatServiceImpl implements ItemCatService {
	
	/** 注入数据访问层代理对象 */
	@Autowired
	private ItemCatMapper itemCatMapper;

	/** 根据父级id查询商品分类 */
	public List<ItemCat> findItemCatByParentId(Long parentId){
		try{
			
			return null;
		}catch (Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
