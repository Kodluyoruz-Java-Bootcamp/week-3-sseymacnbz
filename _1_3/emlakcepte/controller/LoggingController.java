package emlakcepte.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.Logging;
import emlakcepte.model.User;
import emlakcepte.service.LoggingService;

@RestController
@RequestMapping(value="/searchLog")
public class LoggingController {
	@Autowired
	private LoggingService loggingService;
	
	@GetMapping
	public String printLogging(User user) {
		 return loggingService.printLogging(user);
	}
}
