package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.sellergoods.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemCatController
 * @author Mr.White
 * @email zhf306@foxmail.com
 * @date 2017年12月7日 下午2:09:39
 * @version 1.0
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	
}
