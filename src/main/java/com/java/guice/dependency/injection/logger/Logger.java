package com.java.guice.dependency.injection.logger;

import java.util.concurrent.CompletableFuture;

public interface Logger {

    boolean write(String data);

    CompletableFuture<Void> flushAsync();

    boolean close();
}
