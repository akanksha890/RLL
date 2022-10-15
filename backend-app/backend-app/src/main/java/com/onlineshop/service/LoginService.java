package com.onlineshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshop.bean.Login;
import com.onlineshop.bean.Product;
import com.onlineshop.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	public String signIn(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					Login ll = result.get();
					if(ll.getPassword().equals(login.getPassword())) {		
						
				if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("admin")) {
							return "Admin sucessfully login";
				}else if(login.getTypeOfUser().equals(ll.getTypeOfUser()) && login.getTypeOfUser().equals("user")){
							return "User successfully login";
						}else {
							return "Invalid details";
						}					
					}else {
						return "InValid password";
					}
		}else {
			return "InValid emailId";
		}		
	}
	public String signUp(Login login) {
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
					return "Email Id alreay exists";
		}else {
			if(login.getTypeOfUser().equals("admin")) {
				return "You can't create admin account";
			}else {
				loginRepository.save(login);
				return "Account created successfully";
			}
			
		}	
	}
	
	public String deleteusers(String emailid) {
		Optional<Login> result  = loginRepository.findById(emailid);
		if(result.isPresent()) {
			Login l = result.get();
			loginRepository.delete(l);
			return "User deleted successfully";
		}else {
			return "user not present";
		}
	}
	
	public String findUserBytypeOfUser(String typeOfUser) {
		Optional<Login> result  = loginRepository.findById(typeOfUser);
		if(result.isPresent()) {
			Login l = result.get();
			return l.toString();
		}else {
			return "User not present";
		}
	}
	
	public List<Login> getAllUsers() {
		return loginRepository.findAll();
	}
	
	public String forgotPassword(Login login) {
		Optional<Login> result=loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
			Login newLogin=loginRepository.findById(login.getEmailid()).get();
			newLogin.setPassword(login.getPassword());
			
			loginRepository.save(newLogin);
			
			return "password changed successfully";
		}
		else {
			return "user doest not exist";
		}
	}
}
