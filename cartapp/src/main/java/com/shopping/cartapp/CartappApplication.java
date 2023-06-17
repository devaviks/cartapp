package com.shopping.cartapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartappApplication.class, args);
		System.out.println("Shopping Cart Running");
	}
}
