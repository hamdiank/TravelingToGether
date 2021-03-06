package tn.cynapsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.cynapsys.entities.Message;
import tn.cynapsys.entities.Utilisateur;

public interface MessageRepository extends JpaRepository<Message, Long>{

	//TODO
//	@Query("SELECT m FROM Message m  WHERE City.nom LIKE :nomCity")
	//public List<Message> findConversation(@Param("idE") Long idE,@Param("idD") Long idD);
	
	
	List<Message> findByIdDestinataire(Long id);
	
	List<Message> findByAuthor(Utilisateur U);
	
	@Query("SELECT message FROM Message message WHERE (message.idDestinataire =:id1 AND  message.author.idUtilisateur =:id2)OR (message.idDestinataire =:id2 AND  message.author.idUtilisateur =:id1)  ")
	List<Message> findConversation(@Param("id1") Long id1,@Param("id2") Long id2);
}
