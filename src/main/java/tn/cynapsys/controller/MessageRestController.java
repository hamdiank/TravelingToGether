package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.dao.MessageRepository;
import tn.cynapsys.entities.Message;
import tn.cynapsys.services.MessageService;
import tn.cynapsys.services.UtilisateurService;

@RestController
@RequestMapping(value = "/message")
public class MessageRestController {

	@Autowired
	MessageService messageService;

	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private UtilisateurService utilisateurservice;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Message> messages() {
return messageRepository.findConversation(Long.valueOf("1"),Long.valueOf("2")); 
		//return messageService.getAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Message> addMessage(@RequestBody Message m) {

		System.out.println("text "+m.getText());
		System.out.println("auth "+m.getAuthor().getIdUtilisateur());
		System.out.println("auth "+m.getAuthor().getNom());
		System.out.println("id "+m.getIsRead());
		System.out.println("dest "+m.getIdDestinataire());
		Message newM= new Message(m.getIdDestinataire(),utilisateurservice.getUtilisateur(m.getAuthor().getIdUtilisateur()),m.getText());
		newM.setIsRead(m.getIsRead());
		return new ResponseEntity<Message>(messageService.saveMessage(newM), HttpStatus.CREATED);
	}

}
