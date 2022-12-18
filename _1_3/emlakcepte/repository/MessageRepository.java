package emlakcepte.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import emlakcepte.model.Message;

@Repository
public class MessageRepository {
	List<Message> messageRepository = new ArrayList<>();
	
	public void create(Message message) {
		messageRepository.add(message);
	}
	
	public void read() {
		for(Message msg : messageRepository) {
			msg.toString();
		}
	}
	
	public void update(Message message, String content) {
		for(Message msg: messageRepository) {
			if(msg.equals(message)) {
				msg.setContent(content);
			}
		}
	}
	
	public void delete(Message message) {
		for(Message msg: messageRepository) {
			if(msg.equals(message)) {
				messageRepository.remove(message);
			}
		}
	}
}
