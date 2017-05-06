package tn.cynapsys.controller;

import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.services.UtilisateurService;

@RestController
@RequestMapping(value = "/mail")
public class MailController {
	@Autowired
	UtilisateurService utilisateurService;

	@Transactional
	@RequestMapping(value = "/send/{mail}", method = RequestMethod.POST)
	public Boolean saveUser(@PathVariable String mail) {
		System.out.println(mail);
		if (mail != null) {
			Random randomno = new Random();
			long num = (long) Math.abs(randomno.nextInt());
			long num1 = (long) Math.abs(randomno.nextInt());
		Utilisateur u = utilisateurService.getUtilisateurbyEmail(mail);
			String nMotDpass = (long) Math.abs(randomno.nextInt())+"";
			u.setMotDePasse(nMotDpass);
			System.out.println(nMotDpass);
			System.out.println(num);

			System.out.println(num1);

			String d_email = "hamdi.ankoud@gmail.com", d_password = "angoud95290591", d_host = "smtp.gmail.com",
					d_port = "465",

					m_to = mail,

					m_subject = "Changement de mot de passe du compte",

					// get next long value

					m_text = " login: "
							+ mail + " passeword: "+ nMotDpass;

			Properties props = new Properties();
			props.put("mail.smtp.user", d_email);
			props.put("mail.smtp.host", d_host);
			props.put("mail.smtp.port", d_port);
			props.put("mail.smtp.starttls.enable", "true");
		//	props.put("mail.smtp.auth", "true");
		//	props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.port", d_port);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			// SecurityManager security = System.getSecurityManager();

			try {
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(d_email, d_password);
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
		}
		return true;
	}

}