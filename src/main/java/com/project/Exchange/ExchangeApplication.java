package com.project.Exchange;

import com.project.Exchange.Models.Balance;
import com.project.Exchange.Models.Order;
import com.project.Exchange.Models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExchangeApplication {


	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}


}
