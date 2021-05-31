package ma.eheio.schooly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolyApplication.class, args);
	}
/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("").allowedOrigins("http://localhost:4200");
			}
		};
	}
*/
}
