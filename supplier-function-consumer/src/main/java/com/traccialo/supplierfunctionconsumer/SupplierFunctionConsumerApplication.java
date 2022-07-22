package com.traccialo.supplierfunctionconsumer;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SupplierFunctionConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierFunctionConsumerApplication.class, args);
	}
	
	@Bean
    public Supplier<String> myPublisher() {
        return () -> new Date().toString();
    }

    @Bean
    public Function<String, String> myProcessor() {
        return s -> "ML PROCESSED: " + s;
    }

    @Bean
    public Consumer<String> mySubscriber() {
        return s -> System.out.println("ML RECEIVED: " + s);
    }


}
