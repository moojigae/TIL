package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		// 매개변수 있는 생성자 무조건!!! 만들어줘야함
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		
		String value = "";
		
		// 회원가입, 로그인, 비밀번호 변경
		// joinUserPwd , userPwd, newPWd
		if(name != null && (name.equals("joinUserPwd") || name.equals("userPwd") || name.equals("newPwd"))) {
			value = getSha512(super.getParameter(name));
		} else {
			value = super.getParameter(name);
		}
		
		return value;
	}
	
	public static String getSha512(String userPwd) {
		// SHA-512 암호화 방식 ==> Bcrypt를 더 많이 사용함 
		// SHA-512 많은 데이터가 쌓였을 때 복호화가 가능함 
		// Bcrypt 암호화된 값이 다르게 나오기 때문에 복호화 어려움
		
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
