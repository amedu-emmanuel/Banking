package com.BankingApplication.Banking.Service;


import com.BankingApplication.Banking.CustomerEntity.CustomerDeposit;
import com.BankingApplication.Banking.Repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositServiceImpl implements DepositService {

    @Autowired
    DepositRepository depositRepository;
    @Override
    public CustomerDeposit addDeposit(CustomerDeposit customerDeposit) {
        return depositRepository.save(customerDeposit);
    }
}
