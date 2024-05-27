package com.kh.mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Texst {
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("잘됨");
		return "redirect:/";
	}
}
