package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.Message;
import tn.cynapsys.entities.Utilisateur;

public interface MessageService {

	List<Message> getAll();

	List<Message> getMessageByExpiditeur(Utilisateur u);

	List<Message> getMessageByIdDestinataire(Long id);

	Message getMessageById(Long id);

	Message saveMessage(Message m);
}
