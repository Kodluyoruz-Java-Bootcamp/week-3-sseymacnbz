package emlakcepte.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
// RestTemplate ile yazılan client
// RestTemplate ve HttpHeaders için Bean'lar Application.java içerisinde oluşturuldu

@Service
public class BannerServiceClient {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	private static final String serviceAddress = "http://localhost:8081";
	
	public Banner getAll(){
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Banner> entity = new HttpEntity<>(httpHeaders);
		
		ResponseEntity<Banner> response = restTemplate.exchange(serviceAddress, HttpMethod.GET,
				entity, Banner.class);
		
		return response.getBody();
	}
	
	public Banner create(Banner banner) {
		
		HttpEntity<Banner> request = new HttpEntity<>(banner);
		
		ResponseEntity<Banner> createBanner = restTemplate.exchange(serviceAddress, HttpMethod.POST,
				request, Banner.class);
		
		return createBanner;
	}
}
