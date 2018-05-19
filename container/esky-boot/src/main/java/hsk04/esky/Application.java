package hsk04.esky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import hsk04.esky.config.SwaggerConfig;
import hsk04.esky.config.WebConfig;

@SpringBootApplication
@Import({ SwaggerConfig.class, WebConfig.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
