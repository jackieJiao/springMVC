package com.sinoway.zero.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinoway.zero.bean.User;


@Service  
public interface UserService {
	
	public List<User> FindUser(User user); 	
}
    