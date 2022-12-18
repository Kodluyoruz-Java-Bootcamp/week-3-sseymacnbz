package emlakcepte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emlakcepte.model.Message;
import emlakcepte.service.MessageService;
// MessageService CRUD işlemleri için gerekli Controller'lar oluşturuldu.
@RestController
@RequestMapping(value="/messages")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@PostMapping
	public void create(Message message) {
		messageService.create(message);
	}
	
	@GetMapping
	public void read() {
		messageService.read();
	}
	
	@PutMapping("/update")
	public void update(Message message, String content) {
		messageService.update(message, content);
	}
	
	@DeleteMapping("/delete")	
	public void delete(Message message) {
		messageService.delete(message);
	}
}
