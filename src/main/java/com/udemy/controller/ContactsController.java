package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.model.ContactModel;
import com.udemy.model.UsersModel;
import com.udemy.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactsController {

	private final String CONTACT_LIST_VIEW = "contacts";
	private final String CONTACT_FORM = "contactform";
	private final Log LOGG = LogFactory.getLog(ContactsController.class);

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;

	@PostMapping("/")
	public String redirect(@ModelAttribute("usersModel") UsersModel um) {
		if (um.getName().equals("admin") && um.getPassword().equals("admin"))
			return "redirect:/contact/show";

		return "redirect:/login?error";
	}

	@GetMapping("/show")
	public String showContacts(Model m) {
		m.addAttribute("listContact", contactService.listContact());

		return CONTACT_LIST_VIEW;

	}

	@GetMapping("/form")
	public String formContacts(Model m, @ModelAttribute("contactModel") ContactModel cm,
			@RequestParam(name = "id", required = true) int id) {
		LOGG.info("id: " + id);
		ContactModel contactModel = new ContactModel();

		if (id == 0)
			contactModel = cm;
		else
			contactModel = contactService.findContactById(id);

		LOGG.info("**METHOD:formContact** --Variable (ContactModel:) : " + contactModel.toString());
		m.addAttribute("contactModel", contactModel);
		return CONTACT_FORM;
	}

	@PostMapping("/add")
	public String addContact(Model m, @ModelAttribute("contactModel") ContactModel cm) {
		LOGG.info("**METHOD:addContact** --Variable (ContactModel:) : " + cm.toString());
		ContactModel contactModel = contactService.addContact(cm);
		if (contactModel != null)
			m.addAttribute("result", 1);
		else
			m.addAttribute("result", 0);
		m.addAttribute("listContact", contactService.listContact());

		return CONTACT_LIST_VIEW;
	}

	@GetMapping("/remove")
	public String removeContact(@RequestParam(name = "id", required = true) int id) {
		contactService.removeContact(id);
		return "redirect:/contact/show";

	}

}
