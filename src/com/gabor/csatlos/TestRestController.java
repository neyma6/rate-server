package com.gabor.csatlos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googlecode.objectify.ObjectifyService;

import entities.TestEntity;


@Controller()
@RequestMapping("/rest")
public class TestRestController {

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public List<String> test(@RequestParam(required = false) String message, Model model) {
		List<String> ret = new ArrayList<>();
		
		if (message != null) {
			ObjectifyService.ofy().save().entity(new TestEntity(message, message)).now();
		}
		
		List<TestEntity> entities = ObjectifyService.ofy().load().type(TestEntity.class).list();
		
		for (TestEntity entity : entities) {
			ret.add(entity.getMessage());
		}
		
		return ret;
	}
}
