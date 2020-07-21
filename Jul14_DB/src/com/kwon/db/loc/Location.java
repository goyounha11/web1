package com.kwon.db.loc;

public class Location {
	private String name;
	private String distance;
	private String address;
	private String phone;

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public Location(String name, String distance, String address, String phone) {
		super();
		this.name = name;
		this.distance = distance;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
