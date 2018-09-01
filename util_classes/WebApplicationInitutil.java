package org.inetsolv.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplicationInitutil implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
		container.register(EnableAnnotations.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(container);
		Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/");
	}

}
