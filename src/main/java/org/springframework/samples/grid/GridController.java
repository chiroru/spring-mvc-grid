package org.springframework.samples.grid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/grid")
public class GridController {

	@RequestMapping(value = "update", method=RequestMethod.POST, headers = "Accept=application/xml, application/json")
	@ResponseBody
	public List<Contact> update(@RequestBody List<Contact> contact) {

		List<Contact> results = new ArrayList<Contact>();
		results.add(new Contact("name1-updated", "address1"));
		results.add(new Contact("name2-updated", "address2"));
		results.add(new Contact("name3-updated", "address3"));

		return results;
	}
}
