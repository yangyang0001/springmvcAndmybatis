package cn.itcast.ssm.exeption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver{
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String message = null;
		
		if(ex instanceof MyException){
			message = ((MyException)ex).getMessage();
		}else{
			message = "未知错误";
		}
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("message", message);
		
		//去掉前缀和后缀后的页面的名称！
		mv.setViewName("error");
		
		return mv;
	}
}
