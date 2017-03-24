package com.suixingpay.example.Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext contex) throws BeansException {
		applicationContext = contex;
	}

	public static ApplicationContext getContext() {
		return applicationContext;
	}

	public static <T> T getBean(Class<T> cls) {
		return applicationContext.getBean(cls);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanId) {
		return (T) applicationContext.getBean(beanId);
	}
	
	public static Map<String, Object> getCommonDataMap() {
		return getBean("commonData");
	}

}
