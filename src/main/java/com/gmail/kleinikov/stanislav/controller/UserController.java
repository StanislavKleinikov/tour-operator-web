package com.gmail.kleinikov.stanislav.controller;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_ADMIN;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_HOME;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_LOGIN;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_REGISTRATION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gmail.kleinikov.stanislav.entity.User;
import com.gmail.kleinikov.stanislav.service.SecurityService;
import com.gmail.kleinikov.stanislav.service.UserService;
import com.gmail.kleinikov.stanislav.validator.UserValidator;

/**
 * Controller for {@link com.gmail.kleinikov.stanislav.entity.User}'s pages.
 *
 * @author Stanislav Kleinikov
 * @version 1.0
 */

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return PAGE_REGISTRATION;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return PAGE_REGISTRATION;
		}

		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

		return "redirect:/" + PAGE_HOME;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Username or password is incorrect.");
		}

		if (logout != null) {
			model.addAttribute("message", "Logged out successfully.");
		}

		return PAGE_LOGIN;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		return PAGE_ADMIN;
	}
}
