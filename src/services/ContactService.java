package services;

import java.util.ArrayList;

import daos.ContactDAO;
import entities.Contact;

public class ContactService {	
	
	public ContactService(){
		
	}
	
	public void CreateContact(Contact contact){
		ContactDAO cd = new ContactDAO();
		cd.insertContact(contact);
	}
	public void DeleteContact(Contact contact){
		ContactDAO cd = new ContactDAO();
		cd.DeleteContact(contact);
	}
	public ArrayList<Contact> ReadContact(){
		ContactDAO cd = new ContactDAO();
		ArrayList<Contact> al = cd.selectContact();
		return al;
	}
	public void UpdateContact(Contact contact){
		ContactDAO cd = new ContactDAO();
		cd.UpdateContact(contact);
	}	
}
