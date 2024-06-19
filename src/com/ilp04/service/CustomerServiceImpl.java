package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
	 private CustomerDAO customerDAO = new CustomerDAO();


	public ArrayList<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		CustomerDAO customerDAO = new CustomerDAO();
		Connection connection = customerDAO.getConnection();
		customerList = customerDAO.getAllCustomers(connection);
		return customerList;
	}

	
	public int insertIntoCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.insertCustomer(customer);
		
	}


	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.updateCustomer(customer);
	}


	@Override
	public Customer getCustomerByCode(int customerCode) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerByCode(customerCode);
	}



}

