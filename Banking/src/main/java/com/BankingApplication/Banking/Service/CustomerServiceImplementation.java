package com.BankingApplication.Banking.Service;

import com.BankingApplication.Banking.CustomerEntity.Customer;
import com.BankingApplication.Banking.Repository.CustomerRepository;
import com.BankingApplication.Banking.dto.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerServiceImplementation implements CustomerService {
    @Autowired
private CustomerRepository customerRepository;
    @Override
    public Customer addCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerByAccountNumber(Long accNo) {
        return customerRepository.findByaccNo(accNo);
    }
//    @Override
//    public Customer updateCustomer(Long accNo, CustomerRequest customer) {
//        Customer cusdb = customerRepository.findByaccNo(accNo);
//
//        if(Objects.nonNull(customer.getName() )) {
//            cusdb.setName(customer.getName());
//        }
//        if(Objects.nonNull(customer.getAddress() )) {
//            cusdb.setName(customer.getAddress());
//        }
//        if(Objects.nonNull(customer.getNumber() )) {
//            cusdb.setNumber(customer.getNumber());
//        }
//        if(Objects.nonNull(customer.getAccNo() )) {
//            cusdb.setNumber(customer.getAccNo());
//        }
//        if(Objects.nonNull(customer.getAccBalance() )) {
//            cusdb.setAccBalance(customer.getAccBalance());
//        }
//        return customerRepository.save(cusdb);
//    }
}
