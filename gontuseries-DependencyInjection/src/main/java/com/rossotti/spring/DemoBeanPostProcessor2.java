package com.rossotti.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class DemoBeanPostProcessor2 implements BeanPostProcessor, Ordered {

	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("DemoBeanPostProcessor2 processing bean instance after initialization (after init life cycle event) of : " + arg1);
		return arg0;
	}

	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("DemoBeanPostProcessor2 processing bean instance before initialization (after Spring instantiates bean and before init lifecycle event) of : " + arg1);
		return arg0;
	}

	public int getOrder() {
		return 0;
	}

}
