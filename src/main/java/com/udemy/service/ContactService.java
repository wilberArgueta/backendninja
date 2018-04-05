package com.udemy.service;

import java.util.List;

import com.udemy.model.ContactModel;

public interface ContactService {

	public ContactModel addContact(ContactModel cm);

	public List<ContactModel> listContact();

	public ContactModel findContactById(int id);

	public void removeContact(int id);
}
