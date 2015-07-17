package com.gabor.csatlos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller()
@RequestMapping("/rest")
public class TestRestController {

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public List<String> test(Model model) {
		List<String> ret = new ArrayList<>();
		ret.add("egy");
		ret.add("ketto");
		return ret;
	}
}
