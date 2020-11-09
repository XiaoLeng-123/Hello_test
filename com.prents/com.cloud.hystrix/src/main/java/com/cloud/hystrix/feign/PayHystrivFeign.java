package com.cloud.hystrix.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
//统一处理
//@FeignClient(value = "CLOUD-FEIGN",fallback = Hystrixcommond.class)   //设置公用处理熔断的注解
@FeignClient(value = "CLOUD-FEIGN")
@RequestMapping("/feignPay")
public interface PayHystrivFeign {

	@RequestMapping("/pay1")
	public Object getHystrix();
}
