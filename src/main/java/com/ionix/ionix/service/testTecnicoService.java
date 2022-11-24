package com.ionix.ionix.service;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ionix.ionix.model.Result;

public class testTecnicoService {

	@Value("${url.api}")
	private String urlTestTecnico;
	@Value("${api.key}")
	private String key;
	@Autowired
	private RestTemplate restemplate;
	
	public Result testTecnico(String rut) {
	 HttpHeaders headers = new HttpHeaders();
	 headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	 headers.add("x-api-key", key);
	 DESKeySpec keySpec = new DESKeySpec("ionix123456".getBytes("UTF8"));
	 SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	 byte[] cleartext = rut.getBytes("UTF8");
	 Cipher cipher = Cipher.getInstance("DES");
	 String encryptedRut = Base64.encodeToString(cipher.doFinal(cleartext), Base64.DEFAULT);
	 MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	 HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map , headers);
	 ParameterizedTypeReference<Result> rs = new ParameterizedTypeReference<Result>() { 
	 };
	 ResponseEntity<Result> resultado = restemplate.exchange(urlTestTecnico + rut, HttpMethod.GET, request, rs);
	 return resultado.getBody();
	}
	
}
