package org.springframework.samples.grid;

import java.io.Serializable;

public class Contact
implements Serializable {

	private static final long serialVersionUID = 1L;

	public Contact() {
	}
	
	private String name;

	private String address;

	public Contact(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
