package com.imooc.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.exception.UserNotFoundException;
import com.imooc.pojo.User;
import com.imooc.pojo.UserError;
import com.imooc.utils.IMoocJSONResult;

//@Controller
@RestController				//@RestController=@Controller+@ResponseBody
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/getUser")
//	@ResponseBody
	public User getUser() {
		User u = new User();
		u.setName("Mouzu");
		u.setAge(18);
		u.setPassword("1010");
		u.setBirthday(new Date());
		return u;
	}
	
	@RequestMapping("/getUserJson")
//	@ResponseBody
	public IMoocJSONResult getUserJson() {
		User u = new User();
		u.setName("Mouzu");
		u.setAge(18);
		u.setPassword("1010");
		u.setBirthday(new Date());
		return IMoocJSONResult.ok(u);
	}
	
	@RequestMapping("/getUserJson2")
//	@ResponseBody
	public User getUserJson2() {
		User u = new User();
		u.setName("Mouzu");
		u.setAge(18);
		u.setPassword("1010");
		u.setBirthday(new Date());
		if(u.getDesc()==null) {
			throw new UserNotFoundException(u.getName());
		}
		return u;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public UserError UserNotFound(UserNotFoundException e) {
		String name = e.getName();
		return new UserError(4,"User ["+name+"] not found");
	}
}
