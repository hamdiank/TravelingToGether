package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.MessageRepository;
import tn.cynapsys.entities.Message;
import tn.cynapsys.entities.Utilisateur;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public List<Message> getAll() {

		return messageRepository.findAll();
	}

	@Override
	public List<Message> getMessageByAuthor(Utilisateur u) {
		
		return messageRepository.findByAuthor(u);
	}

	@Override
	public List<Message> getMessageByIdDestinataire(Long id) {
		
		return messageRepository.findByIdDestinataire(id);
	}

	@Override
	public Message getMessageById(Long id) {
		
		return messageRepository.findOne(id);
	}

	@Override
	public Message saveMessage(Message m) {
		return messageRepository.save(m);
	}

}
