package bartermall.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class GlobalExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
			/*
			 * handler就是处理器适配器要执行的handler对象（只有方法）handler也就是controller
			 * ex;是截获的系统抛出的异常
			 */

			ex.printStackTrace();
			GlobalException globalException=null;

			//如果抛出的是系统自定义异常则直接转换
			if(ex instanceof GlobalException){
				globalException= (GlobalException)ex;
			}else{
				//如果抛出的不是系统自定义异常则重新构造一个未知错误异常。
				//globalException = new GlobalException("未知错误，请与系统管理员联系！");
				globalException = new GlobalException("对不起，当前界面发生未知错误！！");
			}

			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("msg", globalException.getMessage());
			System.out.println(globalException.getMessage());
			modelAndView.setViewName("msg");//出错转发到这个页面

			return modelAndView;
	}

}
