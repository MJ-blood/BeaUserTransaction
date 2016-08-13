package com.xwood.utx.util;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringBeans  implements ServletContextListener,HttpSessionListener,HttpSessionAttributeListener{
	private static String webRoot = "";// 获取web应用的根目录
	
	

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
	}
	
	public void attributeAdded(HttpSessionBindingEvent event) {
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent event) {
		beanContext = WebApplicationContextUtils.getWebApplicationContext(event
				.getServletContext());
		webRoot = event.getServletContext().getRealPath("/").replace("\\", "/");
	}

	private static ApplicationContext beanContext = null;

	public static Object getBean(String beanId) {
		return beanContext.getBean(beanId);
	}

	public void destroy() {
	}

	/**
	 * @return the webRoot
	 */
	public static String getWebRoot() {
		return webRoot;
	}

	// junit 用，其他地方请斟酌使用。
	public static void setBeanContext(ApplicationContext beanContext) {
		SpringBeans.beanContext = beanContext;
	}

}
