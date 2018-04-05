package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel cm) {
		Contact contact = contactConverter.modelToEntity(cm);
		contact = contactRepository.save(contact);
		return contactConverter.entityToModel(contact);
	}

	@Override
	public List<ContactModel> listContact() {
		List<Contact> contactsList = contactRepository.findAll();
		List<ContactModel> contactsModelList = new ArrayList<>();

		contactsList.forEach((contact) -> contactsModelList.add(contactConverter.entityToModel(contact)));
		return contactsModelList;
	}

	@Override
	public ContactModel findContactById(int id) {
			ContactModel cm = contactConverter.entityToModel(contactRepository.findById(id));
		return cm;
	}

	@Override
	public void removeContact(int id) {
		ContactModel cm = findContactById(id);
		Contact contact = contactConverter.modelToEntity(cm);
		contactRepository.delete(contact);
		
	}
	

}
