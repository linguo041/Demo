package com.roy.demo.batch;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringBatchContext extends GenericApplicationContext{
	
	public void init (String batchXmlConfigurationResource, Class<?>... batchBaseConfiguration) {
		initBaseContext(batchBaseConfiguration);
		initBatchContext(batchXmlConfigurationResource);
		refresh();
	}
	
	private void initBaseContext (Class<?>... annotatedClasses) {
		AnnotatedBeanDefinitionReader annotationReader = new AnnotatedBeanDefinitionReader(this);
		annotationReader.register(annotatedClasses);
	}
	
	private void initBatchContext (String xmlConfigurationResource) {
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(this);
		xmlReader.loadBeanDefinitions(new ClassPathResource(xmlConfigurationResource));
	}
}
