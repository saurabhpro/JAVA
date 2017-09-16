package com.saurabh.springhibernatedemo.dao;

import com.saurabh.springhibernatedemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by saurabhkumar on 08/04/17.
 */

@Repository //allows auto scan as its subclass of Component (only applies to daoimpl)
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject hibernate sessionFactory so that dao can use it for database
	private final SessionFactory sessionFactory; //the name must match the one declared in appconfig

	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	//@Transactional - when no service layer used  DAO was used to handle transaction
	public List<Customer> getCustomers() {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//create the query - old without sorting
		//Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

		//create the query - sorting by last name
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);

		//get the customer by executing the query
		List<Customer> customerList = query.getResultList();

		//return the list of customers from above step
		return customerList;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		/* save the customer ... finally LOL
		currentSession.save(theCustomer);
		*/
		/*
		if primary key is empty insert else update
		 */
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery =
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);

		//updates deletes generic
		theQuery.executeUpdate();
	}
}
