package com.hazi.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hazi.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	//need to inject Session Factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		//Need a hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//Create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute a query and get the result
		List<Customer> customers = theQuery.getResultList();
				
		//return the results
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the customer to DB
		currentSession.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomers(int theId) {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Read from database using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		// Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Delete from database using primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		
	}


	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		//Only search by name if if theSearchName is not empty
		if(theSearchName != null && theSearchName.trim().length()>0) {
			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		}
		else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
		// execute query and get result list
        List<Customer> customers = theQuery.getResultList();
        
        //return the results
		return customers ;
	}

}
