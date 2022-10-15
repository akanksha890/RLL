package com.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.bean.Login;
import com.onlineshop.bean.Product;
import com.onlineshop.service.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

	
	@Autowired
	LoginService loginService;
	
	
	@PostMapping(value = "signIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login) {
		System.out.println("I cam here");
		return loginService.signIn(login);
		
	}
	
	@PostMapping(value = "signUp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login login) {
		System.out.println(login);
		return loginService.signUp(login);
	}
	
	@GetMapping(value="findAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Login> getAllUsers() {
		return loginService.getAllUsers();
	}
	
	@GetMapping(value="findAllUser/{typeOfUser}")
	public String findUserById(@PathVariable("typOfUser") String typeOfUser) {
		return loginService.findUserBytypeOfUser(typeOfUser);
	}
	
	@DeleteMapping(value="deleteusers/{emailid}")
	public String deleteUserUsingemailid(@PathVariable("emailid") String emailid) {
		return loginService.deleteusers(emailid);
	}
	
	@PostMapping(value = "forgotPass",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String forgotPassword(@RequestBody Login login) {
		System.out.println(login);
		return loginService.forgotPassword(login);
	}
}


