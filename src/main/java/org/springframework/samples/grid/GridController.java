package org.springframework.samples.grid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/grid")
public class GridController {

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Contact> initialize() {

		List<Contact> results = new ArrayList<Contact>();
		results.add(new Contact("name1", "address1"));
		results.add(new Contact("name2", "address2"));
		results.add(new Contact("name3", "address3"));

		return results;
	}
}
