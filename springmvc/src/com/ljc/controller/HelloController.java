package com.ljc.controller;

import java.util.Map;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


/**
 * springmvc提供了一种临时给session域中保存数据的方式；
 * 使用一个注解  @SessionAttributes：只能在类上使用
 * 两个属性value ：给 BindingAwareModelMap保存的数据，同时放在session中
 * value="msg" ：指定要给session中保存数据的key
 * 
 * 
 */
//@SessionAttributes(value={},type={String.class})
@Controller
public class HelloController {
	
	
	/**
	 * 以前获取cookie的值
	 * Cookie cookie = request.getCookies();
	 * @param request
	 * @return
	 */
	public String hello01(HttpRequest request) {
		//Cookie cookie = request.getCookies();
		return "success";
	}

	/**
	 * 
	 * @return
	 * @RequestMapping
	 * @RequestParam  获取请求的参数	 @RequestMapping("/hello/?id=123")
	 * @PathVariable  获取路径上的值；@RequestMapping("/hello/{id}")
	 * @RequestHeader  获取请求头中的某个key的值
	 * @CookieValue  获取某个cookie的值
	 * 
	 */
	
	
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("啊啊啊啊");
		return "success";
	}

	
	
	
	
	/**
	 * 提交的数据有乱码：
	 * 	响应乱码：
	 * 		response.setContentType("text/html;charset=UTF-8");
	 * 	请求乱码：
	 * 		GET请求：改server服务器的server.xml文件中的65行<Connector URIEncoding="UTF-8" connectionTimeout="2000" port=80>,
	 * 		POST请求：在第一次获取请求参数之前设置字符编码，requesst.setCharacterEncoding("UTF-8");
	 * 				设置CharacterEncodingFilter过滤器
	 *          <filter>
	 *				<filter-name>CharacterEncodingFilter</filter-name>
	 *			<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
     *			</filter>
	 *			<filter-mapping>
	 *				<filter-name>CharacterEncodingFilter</filter-name>
	 *				<url-pattern>/*</url-pattern>
	 *			</filter-mapping>
	 * 
	 */
	

	@RequestMapping(value="/hello1", method=RequestMethod.POST)
	public String hello1(@PathVariable("id") int id) {
		System.out.println("啊啊啊啊");
		//CharacterEncodingFilter
		return "success";
	}
	
	
	
	/***
	 * 
	 * @param id
	 * @return
	 * 
	 * springmvc中除了原生的api之外，还可以传入Map、Model、ModelMap 的参数里面保存的所有数据都会放在域中，可以在页面保存
	 * 
	 * 	Map<String,Object>：类型 BindingAwareModelMap
	 * 	Model：类型 BindingAwareModelMap
	 * 	ModelMap：类型 BindingAwareModelMap
	 */
	
	
	@RequestMapping(value="/hello2", method=RequestMethod.GET)
	public String hello2(Map<String,Object> map) {
		System.out.println("啊啊啊啊");
		Class<? extends Map> class1 = map.getClass();
		return "success";
	}
	@RequestMapping(value="/hello3", method=RequestMethod.GET)
	public String hello3(Model model) {
		System.out.println("啊啊啊啊");
		
		return "success";
	}
	
	
	/**
	 * 同时把msg保存在session域中临时保存
	 * @param modelMap
	 * @return
	 */
	
	@RequestMapping(value="/hello4", method=RequestMethod.GET)
	public String hello4(ModelMap modelMap) {
		System.out.println("啊啊啊啊");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		modelAndView.addObject("msg",modelMap);
		return "success";
	}
	
	
	@RequestMapping("/hello5")
	public String hello5(ModelMap modelMap) {
		
		return "../../index";
	}
	
	/**
	 * forward:转发到一个页面
	 * forward前缀的转发不会拼串
	 */
	@RequestMapping("hello6")
	public String hello6(ModelMap modelMap) {
		
		return "forward:/index.jsp";
	}
	
	/**
	 * redirect：重定向
	 *   原生的servlet重定向需要加项目名
	 * 
	 */
	@RequestMapping("/hello7")
	public String hello7(ModelMap modelMap) {
		
		return "redirect:/index.jsp";
	}
}
