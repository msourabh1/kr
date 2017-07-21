package com.fdp.kr.request;

import java.util.List;

import com.fdp.kr.datamodel.Tag;

public class RegisterUserRequest {
	private String firstName;
	private String lastName;
	private List<Tag> tags;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
}
