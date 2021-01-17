package com.java.guice.dependency.injection.modules;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.java.guice.dependency.injection.logger.Logger;
import com.java.guice.dependency.injection.logger.SlowLogger;


public class LoggingModule extends AbstractModule {

    @Override
    public void configure() {
        bind(Logger.class).to(SlowLogger.class);
    }

    @Provides
    @Named("file-output-stream")
    public OutputStream getOutputStream(@Named("output-file.name") String fileLocation) throws FileNotFoundException {
        return new FileOutputStream(fileLocation);
    }

    @Provides
    @Named("console-output-stream")
    public OutputStream getConsoleOutputStream(@Named("output-file.name") String fileLocation) throws FileNotFoundException {
        return System.out;
    }
}