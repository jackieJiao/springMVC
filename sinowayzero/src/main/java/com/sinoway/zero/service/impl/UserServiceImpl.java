package com.sinoway.zero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinoway.zero.bean.User;
import com.sinoway.zero.mapper.UserMapper;
import com.sinoway.zero.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;  

	@Override
	public List<User> FindUser(User user) {
		
		return userMapper.FindUser(user);
	}

}
      