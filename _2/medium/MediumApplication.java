package medium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//@EnableFeignClients
//@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class MediumApplication {
	public static void main(String[] args) {
		SpringApplication.run(MediumApplication.class, args);
	}
}
