package cn.itcast.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.Items;

@Controller
public class JSONTest {
	
	//请求JSON,响应JSON
	@RequestMapping("/requestJSON.action")
	public @ResponseBody Items requestJSON(@RequestBody Items items){
		
		return items;
	}
	@RequestMapping("/responseJSON.action")
	public @ResponseBody Items responseJSON(Items items){
		
		return items;
	}
}
