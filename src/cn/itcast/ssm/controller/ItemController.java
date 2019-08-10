package cn.itcast.ssm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.exeption.MyException;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.service.ItemService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@ModelAttribute("itemType")
	public Map<String,String> getItemType(){
		
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		map.put("0001", "电子商品");
		map.put("0002", "母婴必备");
		
		return map;
	}
	
	
	@RequestMapping("/queryItems.action")
	public ModelAndView queryItems() throws Exception{
		
		PageHelper.startPage(1, 5);
		
		List<Items> itemList = new ArrayList<Items>();
		
		itemList = itemService.queryItems();
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("itemsList", itemList);
		
		mv.setViewName("items/itemsList");
		
		PageInfo pageInfo = new PageInfo(itemList);
		
		System.out.println("pageInfo.getPageNum() -------:" + pageInfo.getPageNum());
		System.out.println("pageInfo.getPages() ---------:" + pageInfo.getPages());
		System.out.println("pageInfo.getPageSize() ------:" + pageInfo.getPageSize());
		System.out.println("pageInfo.getTotal() ---------:" + pageInfo.getTotal());
		
		List<Items> list = pageInfo.getList();
		
		for(Items item : list){
			System.out.println("item Id -------:" + item.getId());
		}
		
		return mv;
	}
	
	@RequestMapping("/queryItemsByPrice.action")
	public ModelAndView queryItemsByPrice(float startPrice,float endPrice) throws Exception{
		
		System.out.println("startPrice -------------------:" + startPrice);
		
		System.out.println("endPrice ---------------------:" + endPrice);
		
		PageHelper.startPage(1, 5);
		
		List<Items> itemList = new ArrayList<Items>();
		
		itemList = itemService.queryItemsByPrice(startPrice,endPrice);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("itemsList", itemList);
		
		mv.setViewName("items/itemsList");
		
		PageInfo pageInfo = new PageInfo(itemList);
		
		System.out.println("pageInfo.getPageNum() -------:" + pageInfo.getPageNum());
		System.out.println("pageInfo.getPages() ---------:" + pageInfo.getPages());
		System.out.println("pageInfo.getPageSize() ------:" + pageInfo.getPageSize());
		System.out.println("pageInfo.getTotal() ---------:" + pageInfo.getTotal());
		
		List<Items> list = pageInfo.getList();
		
		for(Items item : list){
			System.out.println("item Id -------:" + item.getId());
		}
		
		return mv;
	}
	
//	@RequestMapping("/editItem.action")
//	public ModelAndView editItem(Integer id) throws Exception{
//		
//		Items item = itemService.getItemById(id);
//		
//		if(item == null){
//			
//			throw new MyException("修改的商品不存在");
//		}
//		
//		ModelAndView mv = new ModelAndView();
//		
//		mv.addObject("item", item);
//		mv.setViewName("items/editItem");
//	
//		return mv;
//	}
	
	@RequestMapping("/editItem.action")
	public String editItem(Integer id,Model model) throws Exception{
		
		Items item = itemService.getItemById(id);
		
		if(item == null){
			throw new MyException("修改的商品不存在");
		}
		model.addAttribute("item", item);
		
		return "items/editItem";
	}

	@RequestMapping("/updateItem.action")
	public String updateItem(Items item,MultipartFile item_pic,HttpServletRequest request) throws Exception{
		
		if(item_pic != null){
			System.out.println("ContentType ----------------- :" + item_pic.getContentType());
			System.out.println("Name ------------------------ :" + item_pic.getName());
			System.out.println("OriginalFilename ------------ :" + item_pic.getOriginalFilename());
			System.out.println("Size ------------------------ :" + item_pic.getSize());
		}
		
		String basePath = request.getRealPath("/image");
		String subName = UUID.randomUUID().toString();
		String fileName = basePath + "\\" + subName;
		item_pic.transferTo(new File(fileName));
		
		item.setPic(subName);
		itemService.updateItem(item);
		
		return "redirect:queryItems.action";
	}
	

	//-------------------------------------测试返回值类型添加的方法,这种是传递不了的！服务器找服务器的方法用redirect----------------------------------
	
	@RequestMapping("/forward.action")
	public ModelAndView toForward(HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView();
		String forwardValue = request.getParameter("forwardParam");
		if(null != forwardValue){
			mv.addObject("forwardValue", forwardValue);
			System.out.println(forwardValue + "---------------" + forwardValue);
		}
		mv.setViewName("forward");
		return mv;
	}
	@RequestMapping("/from.action")
	public String from(HttpServletRequest request,Model model,
			@RequestParam(value="forwardParam",required=true,defaultValue="Hello") String vlaue ){
		
//		request.setAttribute("forwardParam", "Hello World");
		
		System.out.println("forwardParam ------------------ " + vlaue);
		
		System.out.println("------------------------------------------");
		
		return "forward:forward.action";
	}
	
	
	//-------------------------------------set,get------------------------------------------
	
	public ItemService getItemService() {
		return itemService;
	}
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
}
