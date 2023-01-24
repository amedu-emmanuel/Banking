package com.BankingApplication.Banking.Service;

import com.BankingApplication.Banking.CustomerEntity.Customer;
import com.BankingApplication.Banking.dto.CustomerRequest;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    Customer findCustomerByAccountNumber(Long accNo);

//    Customer updateCustomer(Long accNo, CustomerRequest customer);
}
