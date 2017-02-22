package com.xian.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xian.ssm.model.Items;
import com.xian.ssm.model.ItemsCustom;
import com.xian.ssm.model.ItemsQueryVo;
import com.xian.ssm.service.ItemsService;

@Controller
//定义一个根路径，对url的管理更便捷
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	//商品查询
	//@RequestMapping实现对queryItems方法和URL的映射，一个方法对应一个url
    @RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
	    
    	    //System.out.println(request.getParameter("id"));
			//调用service查询数据库，查询商品列表，先模拟
			List<ItemsCustom> itemList=itemsService.findItemsList(itemsQueryVo);
			
			//返回ModelAndView
			ModelAndView modelAndView=new ModelAndView();
			//相当于setAttribut,在JSP页面中通过itemList取数据
			modelAndView.addObject("itemList", itemList);
			
			//指定视图
			//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
			modelAndView.setViewName("items/itemsList");
			
			return modelAndView;
	}
    
    
	//商品信息修改页面的展示
    //@RequestMapping("/editItems")
    //限制http请求的方法
    //出于安全的考虑，对请求方法进行限制
    @RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
    //@RequestParam指定request传入参数名和形参进行绑定
    public String editItems(Model model,@RequestParam(value="id") Integer items_id) throws Exception{
    	
    	ItemsCustom itemsCustom=itemsService.findItemsById(items_id);
    	
    	model.addAttribute("itemsCustom", itemsCustom);
		
		return "items/editItems";
    }
    
    //查询商品信息,输出JSON
    //  /itemsView/{id}中的{id}将传上来的id传到@PathVariable指定的id中
    @RequestMapping("/itemsView/{id}")
    public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id)throws Exception{
    	ItemsCustom itemsCustom=itemsService.findItemsById(id);
    	
    	return itemsCustom;
    }
    
    
    //商品信息修改提交
    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(Model model,HttpServletRequest request,Integer id,@Validated ItemsCustom itemsCustom,BindingResult bindingResult) throws Exception{
    	
    	if(bindingResult.hasErrors()){
    		List<ObjectError> allErrors=bindingResult.getAllErrors();
    		for(ObjectError objectError:allErrors){
    			System.out.println(objectError.getDefaultMessage());
    		}
    		model.addAttribute("allErrors", allErrors);
    		return "items/editItems";
    	}
    	
    	itemsService.updateItems(id, itemsCustom);
    	//返回ModelAndView
    	//ModelAndView modelAndView=new ModelAndView();
    	
    	//指定视图
    	//先返回一个成功页面
    	//modelAndView.setViewName("success");
    	
    	//redirect：重定向。他的定义下request是不能共享的。
    	//return "redirect:queryItems.action";
    	
    	//forward:重定向。他的定义下的request是可以共享的。
    	  return "success";
    	  
    	  
    	//return "success";
    }
    
    //批量删除商品信息
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id)throws Exception{
    	
    	
    	
		return "success";  	
    }
    
    //批量修改商品页面
    @RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
	    
			List<ItemsCustom> itemList=itemsService.findItemsList(itemsQueryVo);
			
			//返回ModelAndView
			ModelAndView modelAndView=new ModelAndView();
			//相当于setAttribut,在JSP页面中通过itemList取数据
			modelAndView.addObject("itemList", itemList);
			
			//指定视图
			//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
			modelAndView.setViewName("items/editItemsQuery");
			
			return modelAndView;
	}
    
    //批量修改商品信息
    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
    	
		return "success";    	
    }
}
