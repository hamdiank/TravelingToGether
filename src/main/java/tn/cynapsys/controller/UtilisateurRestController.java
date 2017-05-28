package tn.cynapsys.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.cynapsys.entities.Reservation;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.services.UtilisateurService;

@CrossOrigin(origins = "*")
@RestController
public class UtilisateurRestController {

	@Autowired
	private ResourceLoader resourceLoader;
	@Autowired
	private UtilisateurService utilisateurService;

	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	public List<Utilisateur> listUtilisateur() {
		return utilisateurService.listUtilisateur();
	}

	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET)
	public Utilisateur getUtilisateur(@PathVariable("id") Long id) {
		return utilisateurService.getUtilisateur(id);
	}
//////////////////////////// Inscription ////////////////////////////////
	
	@RequestMapping(value = "/inscriptionUtilisateur", method = RequestMethod.POST)
	public ResponseEntity<Utilisateur> save(@RequestBody Utilisateur u) {
		System.out.println("Post user");
		String email=u.getEmail();
		Utilisateur utilisateur= utilisateurService.getUtilisateurbyEmail(email);
		if(utilisateur!=null){
			System.out.println(utilisateur.getEmail());
			System.out.println("vous avez déjà faire inscrit ");
			return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
		}
		else{
			utilisateur= utilisateurService.getUtilisateurByLogin(u.getLogin());
			if(utilisateur!= null){
				System.out.println(utilisateur.getLogin());
				System.out.println("ce Login déjà existe ");
				return new ResponseEntity<Utilisateur>(HttpStatus.CONFLICT);
			}
			else{
		
				String mail= u.getEmail();
				String d_email = "becem.kan@gmail.com", d_password = "BK160592enetcom", d_host = "smtp.gmail.com",
						d_port = "465",

						m_to = mail,

						m_subject = "Confirmer Votre Inscription ",

						// get next long value

						m_text = " Vous devez confirmer votre inscription à traver ce lien http://localhost:3000/#/ConfirmerInscription" ;

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
					utilisateurService.update(u);
				} catch (Exception mex) {
					mex.printStackTrace();
				}
				
				System.out.println(utilisateur);
				utilisateurService.saveUtilisateur(u);
				return new ResponseEntity<Utilisateur>(u, HttpStatus.OK);		
			}
		}	
	}

	///////////////////////Confirmation Inscription ///////////////////////////
	@RequestMapping(value = "/confirmerInscription", method = RequestMethod.PUT)
	public void confirmerInscription(@RequestParam String email) {
		System.out.println("utilisateur Rest Controller");
		System.out.println(email);
		utilisateurService.confirmerInscription(email);
	}	
	
	
	
	@RequestMapping(value = "/utilisateur", method = RequestMethod.PUT)
	public Utilisateur update(@RequestBody Utilisateur u) {
		System.out.println(u.getLogin());
		System.out.println(u.getEmail());
		System.out.println(u.getNom());
		System.out.println(u.getNumTelephone());
		System.out.println(u.getPrenom());
		System.out.println(u.getMotDePasse());
		System.out.println(u.getDateNaissance());
		System.out.println(u.getDescription());
		return utilisateurService.update(u);
	}

	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		utilisateurService.delete(id);
	}

	@RequestMapping(value = "/countOfUsers", method = RequestMethod.GET)
	public Long getCount() {
		return utilisateurService.countOfUsers();
	}

	@RequestMapping(value = "/getImage/{id}", method = RequestMethod.GET)
	public ResponseEntity<org.springframework.core.io.Resource> getImage(@PathVariable Long id) {
		System.out.println("enter");
		String image = utilisateurService.getUtilisateur(id).getAvatarSrc();
		try {
			// String path = Paths.get(ROOT, filename).toString();

			org.springframework.core.io.Resource loader = resourceLoader.getResource("classpath:" + image);
			System.out.println(loader);

			return new ResponseEntity<org.springframework.core.io.Resource>(loader, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<org.springframework.core.io.Resource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<String> setUserImage(@RequestParam("file") MultipartFile file, @RequestParam("id") String id,
			HttpServletResponse response) throws Exception {
		System.out.println("heere");
		if (file.isEmpty()) {
			response.setStatus(response.SC_BAD_REQUEST);
			return null;
		}
		try {
			String imagePath = System.getProperty("user.dir") + "/src/main/resources/";
			byte[] bytes = file.getBytes();
			Path path = Paths.get(imagePath + file.getOriginalFilename());
			Files.write(path, bytes);
			Utilisateur u = utilisateurService.getUtilisateur(Long.valueOf(id));
			System.out.println(file.getOriginalFilename());
			u.setAvatarSrc(file.getOriginalFilename());
			utilisateurService.update(u);
			return new ResponseEntity<String>(file.getOriginalFilename(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/uploadVoiture", method = RequestMethod.POST)
	public ResponseEntity<String> setVoitureImage(@RequestParam("file") MultipartFile file,
			@RequestParam("id") String id, HttpServletResponse response) throws Exception {
		System.out.println("heere");
		if (file.isEmpty()) {
			response.setStatus(response.SC_BAD_REQUEST);
			return null;
		}
		try {
			String imagePath = System.getProperty("user.dir") + "/src/main/resources/";
			byte[] bytes = file.getBytes();
			Path path = Paths.get(imagePath + file.getOriginalFilename());

			Files.write(path, bytes);
			Utilisateur u = utilisateurService.getUtilisateur(Long.valueOf(id));
			System.out.println(file.getOriginalFilename());
			System.out.println("pathgg  : " + path);
			u.getVoiture().setVoitureAvatar(file.getOriginalFilename());
			utilisateurService.update(u);
			return new ResponseEntity<String>(file.getOriginalFilename(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/getImageVoiture/{id}", method = RequestMethod.GET)
	public ResponseEntity<org.springframework.core.io.Resource> getImageVoiture(@PathVariable Long id) {
		System.out.println("enter21");
		String image = utilisateurService.getUtilisateur(id).getVoiture().getVoitureAvatar();
		try {
			// String path = Paths.get(ROOT, filename).toString();
			org.springframework.core.io.Resource loader = resourceLoader.getResource("classpath:" + image);
			System.out.println(loader);

			return new ResponseEntity<org.springframework.core.io.Resource>(loader, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<org.springframework.core.io.Resource>(HttpStatus.NOT_FOUND);
		}
	}

}
