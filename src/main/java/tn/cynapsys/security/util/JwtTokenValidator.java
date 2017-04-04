package tn.cynapsys.security.util;

import java.util.Date;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import tn.cynapsys.security.userDto.JwtUserDto;

@Component
public class JwtTokenValidator {
	private final String  secret = "xyZEA1425ZEIxksdjide8Dsdz";
	    
	 public JwtUserDto parseToken(String token,ServletResponse res){
		 
		 JwtUserDto user = null ; 
		 Date referenceTime = new Date();
		 try {
			Claims body  = Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody() ;
			 Date expirationTime = body.getExpiration();
			 if (expirationTime == null || expirationTime.before(referenceTime)) {
		           ((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "token Expired ");
		        return  null; 
			 }
			user = new JwtUserDto() ; 
			user.setUsername(body.getSubject());
			Long iduser = new Long(body.get("userId").toString());
			user.setId(iduser);
			user.setRole(body.get("role").toString());
			return user ; 
		} catch (Exception e) {
		return null ; 
		}
		 
	 }

}
