package com.appsdevlopersblog.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdevlopersblog.app.ws.exceptions.UserServiceException;
import com.appsdevlopersblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdevlopersblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdevlopersblog.app.ws.ui.model.response.UserRest;
import com.appsdevlopersblog.app.ws.userservice.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	Map<String, UserRest> users;

	@Autowired
	UserService userService;

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

		return "get request mapping is called page = " + page + " limit = " + limit + "and sort = " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

		if (true) {
			throw new UserServiceException("A New UserServiceException is thrown");
		}

		if (users != null) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> createUser(@Validated @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = userService.createUser(userDetails);

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public UserRest updateUser(@PathVariable String userId,
			@Validated @RequestBody UpdateUserDetailsRequestModel userDetails) {

		UserRest storedUserDetails = users.get(userId);
		storedUserDetails.setFirstname(userDetails.getFirstName());
		storedUserDetails.setLastname(userDetails.getLastName());

		users.put(userId, storedUserDetails);

		return storedUserDetails;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}
}