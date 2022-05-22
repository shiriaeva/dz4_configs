package com.example.configs.controllers;

import com.example.configs.objects.User;
import com.example.configs.services.InfoService;
import com.example.configs.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final InfoService infoService;

	@GetMapping("/about")
	@ResponseBody
	public String about() {
		return infoService.about();
	}

	@PostMapping("/user")
	@Transactional
	@ResponseBody
	public long createUser(@RequestParam("name") String name, @RequestParam("phone") String phone) {
		return userService.create(name, phone);
	}

	@PatchMapping("/user")
	@Transactional
	@ResponseBody
	public long editUser(@RequestParam("id") long id,
	                 @RequestParam("new-name") String name,
	                 @RequestParam("new-phone") String phone) {
		try {
			return userService.edit(id, name, phone);
		} catch (IllegalAccessException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot modify this user.");
		}
	}

	@Transactional
	@GetMapping("/user")
	@ResponseBody
	public User getUser(@RequestParam("id") long id){
		return userService.getUser(id);
	}
}
