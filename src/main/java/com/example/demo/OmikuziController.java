package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OmikuziController {

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String getOmikuzi(Model model) {

		model.addAttribute("name", new Omikuzi());

		return "input";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String postOmikuzi(
			@ModelAttribute("name") Omikuzi form,
			Model model
			) {

		String[] fortunes = {"大吉", "吉", "中吉", "小吉", "末吉", "凶"};

		Omikuzi o = new Omikuzi();

		model.addAttribute("fortune", "今日の運勢は " + fortunes[(int)(Math.random() * 6)] + " です!");

		return "home";

	}
}
