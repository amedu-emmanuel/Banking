package com.BankingApplication.Banking.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

        @NotBlank
        private String name;

        @NotBlank
        private String number;

        @NotBlank
        private String address;
        @NotBlank
        @NotNull
        private String accNo;

        private Long accBalance;

        public void CustomerRequest(String name, String number, String address, String accNo, String accBalance){
                this.name = name;
                this.number= number;
                this.address = address;
                this.accNo = accNo;
                this.accBalance = Long.parseLong(accBalance);
        }

        public void setAccBalance(String accBalance) {
                this.accBalance = Long.parseLong(accBalance);
        }
    }
