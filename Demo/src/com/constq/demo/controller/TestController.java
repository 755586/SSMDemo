package com.constq.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.constq.demo.pojo.Factory;
import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.User;
import com.constq.demo.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping(value="")
	public String user(HttpServletRequest request) {
		return "test";
	}
}
