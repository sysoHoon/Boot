package com.idev.boot.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.ibatis.annotations.Mapper;

import com.idev.boot.dto.Member;

@Mapper
public class SnsMemberDao {
	// 회원가입 암호화를 위한 Dao
	public Member encode(Member s_mem) {
		
		String ogPw = s_mem.getPw();
		String pw = "";
		
		try {
			MessageDigest mdSha256 = MessageDigest.getInstance("SHA-256");
			
			mdSha256.update(ogPw.getBytes("UTF-8"));
			
			byte[] sha256Hash = mdSha256.digest();
			
			StringBuffer hexSha256hash = new StringBuffer();
			
			for(byte b : sha256Hash) {
				String HexString = String.format("%02x", b);
				hexSha256hash.append(HexString);
			}
			pw = hexSha256hash.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		System.out.println(pw);
		
		s_mem.setPw(pw);
		
		return s_mem;
	}
	
	// 로그인 암호화를 위한 Dao
	public String log_encode(String pw) {
		
		try {
			MessageDigest mdSha256 = MessageDigest.getInstance("SHA-256");
			
			mdSha256.update(pw.getBytes("UTF-8"));
			
			byte[] sha256Hash = mdSha256.digest();
			
			StringBuffer hexSha256hash = new StringBuffer();
			
			for(byte b : sha256Hash) {
				String HexString = String.format("%02x", b);
				hexSha256hash.append(HexString);
			}
			pw = hexSha256hash.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		System.out.println(pw);
		
		return pw;
	}
}
