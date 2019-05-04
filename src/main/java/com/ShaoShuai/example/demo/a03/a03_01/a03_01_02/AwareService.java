package com.ShaoShuai.example.demo.a03.a03_01.a03_01_02;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * 实现BeanNameAware、ResourceLoaderAware接口，获得Bean名称和资源加载的服务
 * 实现ResourceLoaderAware需要重写setResourceLoader
 * 实现BeanNameAware需要重写setBeanName
 * @author ShaoShuai
 *
 */

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

	private String beanName;
	private ResourceLoader loader;
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.loader = resourceLoader;
	}

	public void setBeanName(String name) {
		this.beanName = name;
	}

	public void outputResult() {
		System.out.println("Bean的名称为：" + beanName);
		Resource resoure = loader.getResource("classpath:com/ShaoShuai/example/demo/a03/a03_01/a03_01_02/test.txt");
		try {
			System.out.println("ResourceLoader加载的文件内容为：" + IOUtils.toString(resoure.getInputStream(), "UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
