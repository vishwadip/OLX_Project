package com.zensar.olx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olx.bean.OLXUser;
import com.zensar.olx.service.OLXUserService;

@RestController
public class OLXController {

	@Autowired
	OLXUserService service;
	
	@PostMapping("/user")
	public OLXUser addOLXUser(@RequestBody OLXUser olxUser)
	{
		return this.service.addOLXUser(olxUser);
	}
	
	@GetMapping("/user/{uid}")
	public OLXUser findOLXUserById(@PathVariable(name="uid") int id)
	{
		return this.service.findOLXUser(id);
	}
	
	@GetMapping("/user/find/{userName}") //if we didn't add "find" here will get rt error saying ambiguous as id and username url is same and spring boot will not able differntiate btn id and username 
	public OLXUser findOLXUserByName(@PathVariable(name="userName") String name)
	{
		return service.findOLXUserByName(name);
	}
}
