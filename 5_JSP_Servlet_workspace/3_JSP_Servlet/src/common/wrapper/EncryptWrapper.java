package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getParameter(String name) {
		String value="";
		
		// 회원가입, 로그인, 비밀번호 변경
		// jounUserPwd, userPwd, newPwd
		if(name != null && (name.equals("joinUserPwd") || name.equals("userPwd") || name.equals("newPwd"))) {
			value = getSha512(super.getParameter(name));
		} else {
			value = super.getParameter(name);
		}
		
		return value;
	}

	public static String getSha512(String userPwd) {
		// SHA-512 암호화 방식	==>		Bcrypt을 더 많이 씀(보안성이 더 우수함, Spring에서 배울거)
		String encPwd = null;
		
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte[] bytes = userPwd.getBytes(Charset.forName("UTF-8"));
		md.update(bytes);
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		return encPwd;
	}
}
