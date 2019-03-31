package com.cov.covproxym;

import com.cov.covproxym.Service.LoginService;
import com.cov.covproxym.Service.LoginServiceImpl;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class CovProxymApplication {
	@Autowired
	LoginService loginService ;


	public static void main(String[] args) {
		SpringApplication.run(CovProxymApplication.class, args);
	}


}
