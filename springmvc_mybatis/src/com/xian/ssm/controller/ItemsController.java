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
//����һ����·������url�Ĺ�������
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	//��Ʒ��ѯ
	//@RequestMappingʵ�ֶ�queryItems������URL��ӳ�䣬һ��������Ӧһ��url
    @RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
	    
    	    //System.out.println(request.getParameter("id"));
			//����service��ѯ���ݿ⣬��ѯ��Ʒ�б���ģ��
			List<ItemsCustom> itemList=itemsService.findItemsList(itemsQueryVo);
			
			//����ModelAndView
			ModelAndView modelAndView=new ModelAndView();
			//�൱��setAttribut,��JSPҳ����ͨ��itemListȡ����
			modelAndView.addObject("itemList", itemList);
			
			//ָ����ͼ
			//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
			modelAndView.setViewName("items/itemsList");
			
			return modelAndView;
	}
    
    
	//��Ʒ��Ϣ�޸�ҳ���չʾ
    //@RequestMapping("/editItems")
    //����http����ķ���
    //���ڰ�ȫ�Ŀ��ǣ������󷽷���������
    @RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
    //@RequestParamָ��request������������βν��а�
    public String editItems(Model model,@RequestParam(value="id") Integer items_id) throws Exception{
    	
    	ItemsCustom itemsCustom=itemsService.findItemsById(items_id);
    	
    	model.addAttribute("itemsCustom", itemsCustom);
		
		return "items/editItems";
    }
    
    //��ѯ��Ʒ��Ϣ,���JSON
    //  /itemsView/{id}�е�{id}����������id����@PathVariableָ����id��
    @RequestMapping("/itemsView/{id}")
    public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id)throws Exception{
    	ItemsCustom itemsCustom=itemsService.findItemsById(id);
    	
    	return itemsCustom;
    }
    
    
    //��Ʒ��Ϣ�޸��ύ
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
    	//����ModelAndView
    	//ModelAndView modelAndView=new ModelAndView();
    	
    	//ָ����ͼ
    	//�ȷ���һ���ɹ�ҳ��
    	//modelAndView.setViewName("success");
    	
    	//redirect���ض������Ķ�����request�ǲ��ܹ���ġ�
    	//return "redirect:queryItems.action";
    	
    	//forward:�ض������Ķ����µ�request�ǿ��Թ���ġ�
    	  return "success";
    	  
    	  
    	//return "success";
    }
    
    //����ɾ����Ʒ��Ϣ
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id)throws Exception{
    	
    	
    	
		return "success";  	
    }
    
    //�����޸���Ʒҳ��
    @RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
	    
			List<ItemsCustom> itemList=itemsService.findItemsList(itemsQueryVo);
			
			//����ModelAndView
			ModelAndView modelAndView=new ModelAndView();
			//�൱��setAttribut,��JSPҳ����ͨ��itemListȡ����
			modelAndView.addObject("itemList", itemList);
			
			//ָ����ͼ
			//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
			modelAndView.setViewName("items/editItemsQuery");
			
			return modelAndView;
	}
    
    //�����޸���Ʒ��Ϣ
    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
    	
		return "success";    	
    }
}
