package emlakcepte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import emlakcepte.service.UserService;

@SpringBootApplication

public class EmlakcepteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakcepteServiceApplication.class, args);
	}

	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	// Rest Template için gerekli Bean'ler eklendi
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public HttpHeaders httpHeaders() {
		return new HttpHeaders();
	}

}
