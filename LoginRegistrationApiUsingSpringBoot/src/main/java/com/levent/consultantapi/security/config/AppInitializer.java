package com.levent.consultantapi.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override

	protected String[] getServletMappings() {

		return new String[] { "/" };

	}

	@Override

	protected Class<?>[] getRootConfigClasses() {

		return null;

	}

	@Override

	protected Class<?>[] getServletConfigClasses() {

		return null;

	}

}
