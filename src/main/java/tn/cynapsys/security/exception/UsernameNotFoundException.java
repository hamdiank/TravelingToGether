package tn.cynapsys.security.exception;

public class UsernameNotFoundException extends org.springframework.security.core.userdetails.UsernameNotFoundException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
