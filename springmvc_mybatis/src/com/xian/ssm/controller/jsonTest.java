package com.xian.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xian.ssm.model.ItemsCustom;

@Controller
public class jsonTest{
  
	//����JSON�����JSON
	@RequestMapping("requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
			
		return itemsCustom;
	}
	
	//����Key/Value,���JSON
	@RequestMapping("responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
			
		return itemsCustom;
	}
	
}
