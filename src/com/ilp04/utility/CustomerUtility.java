package com.ilp04.utility;

import java.util.ArrayList;
import java.util.*;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {
	 private static CustomerService customerService = new CustomerServiceImpl();
	 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
    boolean exit = false;
        
        while (!exit) {
        	
            System.out.println("\nWelcome to Customer Management System");
            System.out.println("1. View All Customers");
            System.out.println("2. Insert New Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
            case 1:
                getAllCustomers();
                break;
            case 2:
                insertIntoCustomer();
                break;
            case 3:
                updateCustomer();
                break;
            case 4:
                exit = true;
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        }
    }
        scanner.close();

	}

	private static void getAllCustomers() {
		// TODO Auto-generated method stub
		
		CustomerService customerService = new CustomerServiceImpl();
		ArrayList<Customer> customerList = customerService.getAllCustomers();
		
		//print the details
		
		for(Customer customer : customerList)
		{
			System.out.println(customer.getCustomerCode()+" \t "+ customer.getCustomerFirstname()+" "+customer.getCustomerLastname()+" \t "+customer.getAddress()+" \t "+customer.getPhoneNumber()+" \t "+customer.getAadharNumber());
		}
		
		
		
	}
	
	
	private static void insertIntoCustomer() {
		Scanner scanner = new Scanner(System.in);
        System.out.println("\nInsert New Customer:");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        long phoneNumber = Long.parseLong(scanner.nextLine());

        System.out.print("Enter Aadhar Number: ");
        long aadharNumber = Long.parseLong(scanner.nextLine());

        Customer newCustomer = new Customer(0, firstName, lastName, address, phoneNumber, aadharNumber);
        int rowsInserted = customerService.insertIntoCustomer(newCustomer);

        if (rowsInserted > 0) {
            System.out.println("New customer inserted successfully.");
        } else {
            System.out.println("Failed to insert new customer.");
        }
    }
	
	private static void updateCustomer() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Customer Code to Update: ");
        int customerCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt()

        Customer existingCustomer = customerService.getCustomerByCode(customerCode);

        if (existingCustomer == null) {
            System.out.println("Customer not found with code: " + customerCode);
            return;
        }

        System.out.println("Current Details:");
        System.out.println("Name: " + existingCustomer.getCustomerFirstname() + " " + existingCustomer.getCustomerLastname());
        System.out.println("Address: " + existingCustomer.getAddress());
        System.out.println("Phone Number: " + existingCustomer.getPhoneNumber());
        System.out.println("Aadhar Number: " + existingCustomer.getAadharNumber());

        System.out.println("\nSelect Field to Update:");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Address");
        System.out.println("4. Phone Number");
        System.out.println("5. Aadhar Number");
        System.out.print("Enter your choice: ");

        int fieldChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt()

        switch (fieldChoice) {
            case 1:
                System.out.print("Enter New First Name: ");
                String newFirstName = scanner.nextLine();
                existingCustomer.setCustomerFirstname(newFirstName);
                break;
            case 2:
                System.out.print("Enter New Last Name: ");
                String newLastName = scanner.nextLine();
                existingCustomer.setCustomerLastname(newLastName);
                break;
            case 3:
                System.out.print("Enter New Address: ");
                String newAddress = scanner.nextLine();
                existingCustomer.setAddress(newAddress);
                break;
            case 4:
                System.out.print("Enter New Phone Number: ");
                long newPhoneNumber = Long.parseLong(scanner.nextLine());
                existingCustomer.setPhoneNumber(newPhoneNumber);
                break;
            case 5:
                System.out.print("Enter New Aadhar Number: ");
                long newAadharNumber = Long.parseLong(scanner.nextLine());
                existingCustomer.setAadharNumber(newAadharNumber);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        int rowsUpdated = customerService.updateCustomer(existingCustomer);

        if (rowsUpdated > 0) {
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Failed to update customer.");
        }
    }


}

