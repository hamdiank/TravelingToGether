package tn.cynapsys.controller;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.dao.AnnonceCovoiRepository;
import tn.cynapsys.dao.ReservationRepository;
import tn.cynapsys.entities.Aeroport;
import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.Reservation;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.services.AnnonceService;
import tn.cynapsys.services.ReservationService;

@CrossOrigin(origins="*")
@RestController
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private AnnonceService annonceService;
	
	

		
/*	@RequestMapping(value = "/reservation", method=RequestMethod.PUT)
	public Reservation ajout(@RequestParam Long idAnnonceCovoi,@RequestParam Long idUtilisateurReservation, @RequestParam Boolean etat) {
		Reservation reservation= reservationService.getReservationByUtilisateurReservationAndByAnnonceCovoi(idUtilisateurReservation, idAnnonceCovoi);
		if(reservation!=null){
				System.out.println("vous avez déjà faire une reservation");
				return new Reservation();
		}
		else{
			return reservationService.demandeReservation(idAnnonceCovoi, idUtilisateurReservation, etat);
		}
	
	}*/
	
	@RequestMapping(value = "/reservation", method=RequestMethod.PUT)
	public ResponseEntity<Reservation> ajout(@RequestParam Long idAnnonceCovoi,@RequestParam Long idUtilisateurReservation, @RequestParam Boolean etat) {
		//Reservation reservation= reservationService.getReservationByUtilisateurReservationAndByAnnonceCovoi(idUtilisateurReservation, idAnnonceCovoi);
		AnnonceCovoi annonceCovoi= annonceService.getAnnonceCovoiById(idAnnonceCovoi);
		Long nombrePlaces= annonceCovoi.getNombrePlaces();
		if(nombrePlaces>0){
			
			Reservation reservation= reservationService.getReservationByUtilisateurReservationAndByAnnonceCovoi(idUtilisateurReservation, idAnnonceCovoi);
			if(reservation!=null){
				System.out.println(reservation);
				System.out.println("vous avez déjà fait une reservation");
				return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
		}else{
			reservation=reservationService.demandeReservation(idAnnonceCovoi, idUtilisateurReservation, etat);
			System.out.println(reservation);
			System.out.println("reservation ajoutée");
		return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
		}
			
		}
		else{
			System.out.println("complet");
			return new ResponseEntity <Reservation>(HttpStatus.CONFLICT);
		}
	}
	@RequestMapping(value = "/getReservationsByAnnonceCovoi", method=RequestMethod.GET)
	public List <Reservation> getReservationsByAnnonceCovoi(@RequestParam Long idAnnonceCovoi) {
		return reservationService.getReservationByAnnonceCovoi(idAnnonceCovoi);
	}
	
	@RequestMapping(value = "/getReservationsByUtilisateurReservation", method=RequestMethod.GET)
	public List <Reservation> getReservationsByUtilisateurReservation(@RequestParam Long idUtilisateur) {
		return reservationService.getReservationByUtilisateurReservation(idUtilisateur);
	}
	
	@RequestMapping(value = "/annulerReservation/{idReservation}", method=RequestMethod.DELETE)
	public void annulerReservation(@PathVariable Long idReservation) {
		Reservation reservation= reservationService.getReservationById(idReservation);
		if(reservation.getConfirmation()==true){
			Utilisateur utilisateur1=reservation.getUtilisateurReservation();
			System.out.println(utilisateur1.getEmail());
			Utilisateur utilisateur2=reservation.getAnnonceCovoi().getUtilisateur();
			System.out.println(utilisateur2.getEmail());
			
			String mail= utilisateur2.getEmail();
			String d_email ="becem.kan@gmail.com", d_password = "BK160592enetcom", d_host = "smtp.gmail.com",
					d_port = "465",

					m_to = mail,

					m_subject = "Annulation de réservation de Covoiturage",

					// get next long value

					m_text = "Bonjour, " +"\n" +utilisateur1.getNom() +" " + utilisateur1.getPrenom()+ " a annulé sa réservation de votre offre de covoiturage du trajet " + reservation.getAnnonceCovoi().getPaysDepart()+ ", "+reservation.getAnnonceCovoi().getVilleDepart()+ " --> "+ reservation.getAnnonceCovoi().getPaysArrivee()+ ", " + reservation.getAnnonceCovoi().getVilleArrivee()+  " de date de départ " + reservation.getAnnonceCovoi().getDateDepart();

			Properties props = new Properties();
			props.put("mail.smtp.user", d_email);
			props.put("mail.smtp.host", d_host);
			props.put("mail.smtp.port", d_port);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port", d_port);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			//SecurityManager security = System.getSecurityManager();

			try {
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("becem.kan@gmail.com", "BK160592enetcom");
					}
				});
				session.setDebug(true);
				MimeMessage msg = new MimeMessage(session);
				msg.setText(m_text);
				msg.setSubject(m_subject);
				msg.setFrom(new InternetAddress(d_email));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
				Transport.send(msg);
			} catch (Exception mex) {
				mex.printStackTrace();
			}
			
			reservationService.deleteReservation(idReservation);
			
		}else{
			reservationService.deleteReservation(idReservation);
		}
		
	}
	
	/*@RequestMapping(value = "/accepterReservation", method=RequestMethod.PUT)
	public Reservation accepterReservation(@RequestParam Long idReservation,@RequestParam Boolean etat ) {
		return reservationService.accepterReservation(idReservation, etat);
	}*/
	
	@RequestMapping(value = "/accepterReservation/{idReservation}", method=RequestMethod.PUT)
	public ResponseEntity<Reservation> accepterReservation(@PathVariable Long idReservation ) {
		Reservation reservation= reservationService.getReservationById(idReservation);
		AnnonceCovoi annonceCovoi=  reservation.getAnnonceCovoi();
		Long nombrePlaces= annonceCovoi.getNombrePlaces();
		
		if(annonceCovoi.getNombrePlaces()> 0){
			System.out.println("nombre de places disponibles");
			reservation =reservationService.accepterReservation(idReservation);
			return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
		}
		else{
			System.out.println("nombre de places non disponibles");
			return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
		}
		
	}
	@RequestMapping(value = "/refuserReservation/{idReservation}", method=RequestMethod.PUT)
	public Reservation refuserReservation(@PathVariable Long idReservation ) {
		return reservationService.refuserReservation(idReservation);
	}
			
	
	@RequestMapping(value = "/AllReservations", method = RequestMethod.GET)
	public List<Reservation> listReservations() {
		
		return reservationService.getAllReservation();
		
	}
	
	/*    get Reservations En attente
	@RequestMapping(value = "/getReservationsEnAttente", method = RequestMethod.GET)
	public List<Reservation> listReservationsEnAttente(@RequestParam Long idAnnonceCovoi) {	
		return reservationService.getReservationByAnnonceCovoiEnAttente(idAnnonceCovoi);
		
	}*/
	
	/////////
	
	@RequestMapping(value = "/confirmerReservation/{idReservation}", method=RequestMethod.PUT)
	public ResponseEntity<Reservation> confirmerReservation(@PathVariable Long idReservation) {
		Reservation reservation= reservationService.getReservationById(idReservation);
		AnnonceCovoi annonceCovoi=  reservation.getAnnonceCovoi();
		Long nombrePlaces= annonceCovoi.getNombrePlaces();
		System.out.println("nombre de places="+ nombrePlaces);
		if(nombrePlaces> 0){
			Utilisateur utilisateur1=reservation.getUtilisateurReservation();
			System.out.println(utilisateur1.getEmail());
			Utilisateur utilisateur2=reservation.getAnnonceCovoi().getUtilisateur();
			System.out.println(utilisateur2.getEmail());
			
			String mail= utilisateur2.getEmail();
			String d_email ="becem.kan@gmail.com", d_password = "BK160592enetcom", d_host = "smtp.gmail.com",
					d_port = "465",

					m_to = mail,

					m_subject = "Confirmation de réservation de Covoiturage",

					// get next long value

					m_text = "Bonjour, " +"\n" +utilisateur1.getNom() +" " + utilisateur1.getPrenom()+ " a confirmé la réservation de votre offre de covoiturage du trajet " + reservation.getAnnonceCovoi().getPaysDepart()+ ", "+reservation.getAnnonceCovoi().getVilleDepart()+ " --> "+ reservation.getAnnonceCovoi().getPaysArrivee()+ ", " + reservation.getAnnonceCovoi().getVilleArrivee()+  " de date de départ " + reservation.getAnnonceCovoi().getDateDepart();

			Properties props = new Properties();
			props.put("mail.smtp.user", d_email);
			props.put("mail.smtp.host", d_host);
			props.put("mail.smtp.port", d_port);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port", d_port);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			//SecurityManager security = System.getSecurityManager();

			try {
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("becem.kan@gmail.com", "BK160592enetcom");
					}
				});
				session.setDebug(true);
				MimeMessage msg = new MimeMessage(session);
				msg.setText(m_text);
				msg.setSubject(m_subject);
				msg.setFrom(new InternetAddress(d_email));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
				Transport.send(msg);
			} catch (Exception mex) {
				mex.printStackTrace();
			}
			reservation =reservationService.confirmerReservation(idReservation);
			return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
		}
		else{
			System.out.println("nombre de places indisponibles");
			return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	///////////
	
	

}
