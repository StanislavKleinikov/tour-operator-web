package com.gmail.kleinikov.stanislav.controller;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_HOME;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_REGISTRATION;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmail.kleinikov.stanislav.entity.User;
import com.gmail.kleinikov.stanislav.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@RequestMapping("/registration/form")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		return PAGE_REGISTRATION;
	}

	@RequestMapping("registration/submit")
	@PostMapping
	public String submit(@ModelAttribute("user") @Valid User user, HttpServletRequest request, Model model,
			BindingResult bindingResult) {
		if (!user.getPassword().equals(request.getParameter("confirm_password"))) {
			bindingResult.addError(new ObjectError("Confirm_password", "The passwords mismatch"));
		}
		if (bindingResult.hasErrors()) {
			return PAGE_REGISTRATION;
		}
		userService.saveUser(user);

		return "redirect:/" + PAGE_HOME;
	}

}
