package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Message;
import tn.cynapsys.services.MessageService;

@RestController
@RequestMapping(value = "/message")
public class MessageRestController {

	@Autowired
	MessageService messageService;
	
	
	
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Message> city() {

		return messageService.getAll();
	}
	
	
}
