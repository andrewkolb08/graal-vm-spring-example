package com.thrivent.lnl.graalvmexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class GraalVmExampleApplication {

	@RequestMapping("/")
	String home(){
		//this is broken until bug in Graal is fixed when working with Spring Boot
		// try( Context context = Context.create()){
		// 	context.eval("python", "rint('Hello python!')");
		// }
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(GraalVmExampleApplication.class, args);
	}

}
