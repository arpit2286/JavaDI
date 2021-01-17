package com.java.guice.dependency.injection;

import java.util.concurrent.ExecutionException;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.java.guice.dependency.injection.modules.LoggingModule;
import com.java.guice.dependency.injection.modules.PropertiesModule;

public class Main {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PropertiesModule(), new LoggingModule());
		final TaskManager taskManager = injector.getInstance(TaskManager.class);
		try {
			taskManager.execute().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
