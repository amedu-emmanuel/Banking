package com.BankingApplication.Banking.Repository;

import com.BankingApplication.Banking.CustomerEntity.CustomerDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<CustomerDeposit, Long> {
}
