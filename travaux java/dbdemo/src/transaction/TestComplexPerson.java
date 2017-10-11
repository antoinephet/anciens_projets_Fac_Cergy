package transaction;

import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.hibernate.Session;

import utils.DataUtility;

public class TestComplexPerson extends JFrame {

	private static final long serialVersionUID = -6648333342869730650L;

	public TestComplexPerson(ComplexPerson person) {
		JLabel jLabel = new JLabel(new ImageIcon(person.getPortrait()));
		add(jLabel);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		DataInit.createTables();

		Session session = DBConnection.getSession();
		session.beginTransaction();
		Name name = new Name("Jean", "Dubois");
		Address address = new Address("2", "rue Pasteur", "75014", "Paris", "France");
		ComplexPerson person = new ComplexPerson(name, address, Gender.MALE, DataUtility.createBirthdate(1, 1, 1990));
		person.setPortrait(DataUtility.createPortrait("portrait.jpg"));
		Serializable id = session.save(person);
		session.getTransaction().commit();

		session.beginTransaction();
		ComplexPerson retrievedPerson = (ComplexPerson) session.get(ComplexPerson.class, id);
		System.out.println(retrievedPerson.toString());
		session.getTransaction().commit();

		new TestComplexPerson(person);

	}
}
