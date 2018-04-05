package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public Contact modelToEntity(ContactModel cm) {

		Contact c = new Contact();
		c.setId(cm.getId());
		c.setFirstName(cm.getFirstName());
		c.setLastName(cm.getLastName());
		c.setTelephone(cm.getTelephone());
		c.setCity(cm.getCity());

		return c;

	}

	public ContactModel entityToModel(Contact c) {

		ContactModel cm = new ContactModel();
		cm.setId(c.getId());
		cm.setFirstName(c.getFirstName());
		cm.setLastName(c.getLastName());
		cm.setTelephone(c.getTelephone());
		cm.setCity(c.getCity());

		return cm;
	}

}
