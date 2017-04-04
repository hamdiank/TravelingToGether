package tn.cynapsys.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import tn.cynapsys.security.model.AuthenticatedUser;
import tn.cynapsys.security.userDto.JwtUserDto;
import tn.cynapsys.security.util.JwtTokenValidator;



public class JwtAuthenticationTokenFilter extends GenericFilterBean {

	private JwtTokenValidator jwtTokenValidator = new JwtTokenValidator();

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String header = request.getHeader("Authorization");
		if (header == null || !header.startsWith("Bearer")) {
			((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
			return;
		}
		String token = header.substring(7);

		JwtUserDto user = jwtTokenValidator.parseToken(token,res);

		if (user == null) {
			((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
			return;
		} else {
			List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(user.getRole()));
			AuthenticatedUser authenticatedUser = new AuthenticatedUser(user.getId(), user.getUsername(), token,
					authorities);
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					authenticatedUser, "", authorities);
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			chain.doFilter(request, response);

		}

	}

}

