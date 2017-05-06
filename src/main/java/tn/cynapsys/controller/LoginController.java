package tn.cynapsys.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Role;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.security.exception.UsernameNotFoundException;
import tn.cynapsys.security.userDto.JwtUserDto;
import tn.cynapsys.security.util.JwtTokenGenerator;
import tn.cynapsys.services.UtilisateurService;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	private UtilisateurService utilisateurService;
	// @Autowired
	// private RoleUtilisateurService roleUtilisateurService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> login(@RequestBody Utilisateur utilisateur,
			HttpServletResponse response) {
		BCryptPasswordEncoder passencrypt = new BCryptPasswordEncoder();
		// System.out.println(utilisateur.getLogin());
		// System.out.println(utilisateur.getMotDePasse());

		Utilisateur utilisateur2 = utilisateurService.getUtilisateurByLogin(utilisateur.getLogin());
		// Utilisateur utilisateur2 =
		// utilisateurService.getUtilisateurByLogin(login);
		// System.out.println(utilisateur2.getLogin() + " tey " +
		// utilisateur2.getMotDePasse());

		if (utilisateur2 != null) {

			System.out.println("enter 1");

			String password = utilisateur2.getMotDePasse();
			// System.out.println(password);
			// System.out.println(utilisateur.getMotDePasse());
			// if (!passencrypt.matches(/*utilisateur.getMotDePasse()*/pass,
			// password)) {
			if (!password.equals(utilisateur.getMotDePasse())) {
				// System.out.println("enter 2");
				// if(!pass.equals(password)) {
				response.setStatus(response.SC_UNAUTHORIZED);
				throw new UsernameNotFoundException("Wrong Passowrd");

			}
			Long iduser = utilisateur2.getIdUtilisateur();

			// in prod
			Role role = utilisateurService.getUserRole(iduser);
			System.out.println(role);
			
			JwtUserDto jwtUserDto = new JwtUserDto();
			jwtUserDto.setId(iduser);

			jwtUserDto.setRole(role.getTypeRole());
			jwtUserDto.setUsername(utilisateur2.getLogin());
			String token = JwtTokenGenerator.generateToken(jwtUserDto);
			System.out.println(token);
			response.setHeader("Token", token);
			response.setStatus(response.SC_ACCEPTED);
			return new ResponseEntity<String>(token, HttpStatus.ACCEPTED);
		} else {
			response.setStatus(response.SC_UNAUTHORIZED);
			System.out.println("null null null bhhhhb");
			return null;
			// throw new UsernameNotFoundException("Wrong Credentials ");
		}
	}
}
