package emlakcepte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.Logging;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.service.LoggingService;
import emlakcepte.service.RealtyService;

@RestController
@RequestMapping(value = "/realtyes")
public class RealtyController {

	@Autowired
	private RealtyService realtyService;
	
	@Autowired
	private LoggingService loggingService;
	// GET /realtyes
	@GetMapping
	public List<Realty> getAll() {
		return realtyService.getAll();
	}

	// POST /realtyes
	@PostMapping
	public ResponseEntity<Realty> create(@RequestBody Realty realty) {
		System.out.println("realty" + realty);
		realtyService.create(realty);
		return new ResponseEntity<>(realty, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/district")
	public void getByDistrict(User user, String province, String district) {
		loggingService.searchingLog(new Logging(user, province, district));
		realtyService.getByDistrict(user, province, district);
	}
	
	
	@GetMapping(value="/showcase")
	public void getShowcase() {
		realtyService.getShowcase();
	}
	
	@GetMapping(value="/realtySize")
	public void getSizeOfRealtyByProvince(String province) {
		realtyService.getShowcase();
	}

}
