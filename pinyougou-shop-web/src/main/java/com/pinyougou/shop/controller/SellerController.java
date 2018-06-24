package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Seller;
import com.pinyougou.sellergoods.service.SellerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * SellerController
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年12月7日 下午2:09:18
 * @version 1.0
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Reference(timeout = 10000)
	private SellerService sellerService;

	/** 添加商家 */
	@PostMapping("/save")
	public boolean save(@RequestBody Seller seller){
		try{
			sellerService.saveSeller(seller);
			return true;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}