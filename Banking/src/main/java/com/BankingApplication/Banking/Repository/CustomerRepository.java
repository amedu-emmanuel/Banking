package com.BankingApplication.Banking.Repository;

import com.BankingApplication.Banking.CustomerEntity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByaccNo(Long accNo);



    @Query(value = "SELECT id, acc_balance FROM customer WHERE acc_no = :accNo", nativeQuery = true)
    Customer findCustomerByAccountNumberNative(@Param("accNo") Long accNo);
}
