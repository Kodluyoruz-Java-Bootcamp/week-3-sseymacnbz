package emlakcepte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.model.Message;
import emlakcepte.repository.MessageRepository;

@Service
public class MessageService {
	// Message Service için gerekli olan CRUD işlemleri gerçekleştirildi.
	@Autowired
	MessageRepository messageRepository;
	
	public void create(Message message) {
		messageRepository.create(message);
	}
	
	public void read() {
		messageRepository.read();
	}
	
	public void update(Message message, String content) {
		messageRepository.update(message, content);
	}
	
	public void delete(Message message) {
		messageRepository.delete(message);
	}
}
