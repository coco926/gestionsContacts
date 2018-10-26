package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Contact;

public class ContactDAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/jee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String uid = "rivelson"; 
	private String passwd = "041048770";
	private Connection cx = null;
	private Statement stmt = null;

	public ContactDAO(){
		
	}
	
	public void insertContact(Contact contact) {	
		connect();
		stmt = cx.createStatement();
		String requete = "INSERT INTO Contact(firstName, lastName, email) VALUES " +

		"('" + contact.getFirstName() + "', '"+contact.getLastName()+ "', '" + contact.getEmail() + "')";
		
		int nb;
		try {
			nb = stmt.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nombre de lignes mises a jour=" + nb);		
		
	}
	
	public ArrayList<Contact> selectContact() {

		ArrayList<Contact> al = new ArrayList<Contact>();
		
		// on suppose que l’instruction de chargement du pilote a été executée
		try 
		{	
			connect();
			stmt = cx.createStatement();
			String requete = "SELECT id, prenom, nom, email FROM TableContact ";
			
			ResultSet rs=  stmt.executeQuery(requete);
			
			while (rs.next()) {
				Contact c = new Contact();
				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("prenom"));
				c.setLastName(rs.getString("nom"));
				c.setEmail(rs.getString("email"));
				al.add(c);
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e); 
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

		finally {
		try {

			if(stmt != null) stmt.close();
			if(cx != null) cx.close();
	
		}

		catch (Exception e) { throw new RuntimeException(e); }
		}
		
		return al;
	}

	public void DeleteContact(Contact contact){
	
	}
	
	public void UpdateContact(Contact contact) {
		
	}
	
	public void connect() {	
		
		try{
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
		}
		catch (SQLException e) {
			throw new RuntimeException(e); 
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt != null) stmt.close();
				if(cx != null) cx.close();
			}
			catch (Exception e) { 
				throw new RuntimeException(e); 
			}
		}
	}
	
}
