package com.example.demo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.concurrent.ThreadFactory;

import static org.assertj.core.api.Assertions.assertThat;

class ReflectionTest {

	@Test
	void reflectionIssueReproduction() throws Exception	{
		// copied from ch.qos.logback.core.util.ExecutorServiceUtil#makeThreadFactory
		Method ofVirtualMethod = Thread.class.getMethod("ofVirtual");
		Object threadBuilderOfVirtual = ofVirtualMethod.invoke(null);
		Method factoryMethod = threadBuilderOfVirtual.getClass().getMethod("factory");
		ThreadFactory result = (ThreadFactory) factoryMethod.invoke(threadBuilderOfVirtual);

		assertThat(result).isNotNull();
	}

}
