package com.bigredgames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the front interfacing controller for the guest 
 * data interface.
 * 
 * METHODS:
 * 	GET:
 * 
 * 	POST:
 * 
 * 
 * @author Dave
 *
 */

@RestController
public class GuestController {

	@GetMapping("/{id}")
	public void saveGuestId(@PathVariable("id") int id) {
		System.out.println("I am here! " + id);
	}
}
