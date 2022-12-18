package emlakcepte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.model.Logging;
import emlakcepte.model.User;
import emlakcepte.repository.LoggingRepository;

@Service
public class LoggingService {
	
	@Autowired
	private LoggingRepository loggingRepository;
	
	public void searchingLog(Logging log) { // Arama logları için metod
		loggingRepository.searchingLog(log);
	}
	
	public String printLogging(User user) { // Logları bastırmak için metod
		return loggingRepository.printLogging(user);
	}
}
