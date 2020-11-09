package com.cloud.hystrix.hystrixcommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.hystrix.feign.PayHystrivFeign;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@Component
@RequestMapping("hys")
//@DefaultProperties(defaultFallback = "quan_jv_hys")  //公用处理熔断的类
public class Hystrixcommond {

	@Autowired
	private PayHystrivFeign payHystrivFeign;

	@HystrixCommand(fallbackMethod = "/pay1FallBack", commandProperties = { // 设置超时时间
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })
	public Object getHystrix() {
		return payHystrivFeign.getHystrix();
	}

	public Object pay1FallBack() {
		return "我出问题了";

	}

	/*
	 * @HystrixCommand(fallbackMethod="/getHystrix1FallBack",commandProperties={
	 * 
	 * @HystrixProperty(name="circuitBreak.enable",value="true"),
	 * 
	 * @HystrixProperty(name="circuitBreak.requestVolumeThresholg",value="10"),
	 * 
	 * @HystrixProperty(name="circuitBreak.slepWindowInMilliseconds",value="1000"),
	 * 
	 * @HystrixProperty(name="circuitBreak.errorThresholdPercentage",value="60")})
	 * 
	 * public Object getHystrix1() { return payHystrivFeign.getHystrix(); }
	 * 
	 * public Object getHystrix1FallBack() { return "稍后重试"; }
	 */

	/*
	 * @HystrixCommand public Object getHystrix2() { return
	 * payHystrivFeign.getHystrix(); }
	 * 
	 * public Object getHystrix2FallBack() { return "稍后重试"; }
	 */
	
	/*
	 * public Object quan_jv_hys() { return "我是公用的熔断，我出问题了";
	 * 
	 * }
	 */
}
