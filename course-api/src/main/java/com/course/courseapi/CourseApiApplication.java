package com.course.courseapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.course.courseapi.serviceImplementation.TestService;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
@EnableTransactionManagement
@ComponentScan(basePackages = "com")
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "")})
public class CourseApiApplication {

	@Autowired
	private TestService testService;

	public static void main(String[] args) {
		String S = "";

		SpringApplication.run(CourseApiApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() { // Return the instance of docket instance
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfor());
	}

	@Bean
	private static ApiInfo apiInfor() {
		return new ApiInfo("Course API", "Apis of course Website. Copyright By Sidharth Das ", "1.0", "Free To Use", "",
				"", "");
	}

}
