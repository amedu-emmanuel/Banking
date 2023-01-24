package com.BankingApplication.Banking.Controller;

import com.BankingApplication.Banking.CustomerEntity.Customer;
import com.BankingApplication.Banking.CustomerEntity.CustomerDeposit;
import com.BankingApplication.Banking.Service.CustomerService;
import com.BankingApplication.Banking.Service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @Autowired
    private DepositService depositService;


    @PostMapping("/add")
    public String createTodoItem(Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Home";
        }
        long account = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        customer.setAccNo(account);

        customerService.addCustomer(customer);
        model.addAttribute("account", account);
        return "Success";
    }


    @GetMapping("/check")
    public String index(Customer customer) {

        return "checkbalance";
    }

    @GetMapping("/{accNo}")
    public Customer findCustomerByAccountNumber(@PathVariable("accNo") Long accNo){
        return customerService.findCustomerByAccountNumber(accNo);

    }

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("Home");
        return model;
    }

    @GetMapping("/account")
    public ModelAndView checkAccount(){
        ModelAndView model = new ModelAndView("checkbalance");
        return model;
    }

    @GetMapping("/OpenAccount")
    public ModelAndView createaccount(Model model, Customer customer){

        return new ModelAndView("OpenAccount");
    }

    @PostMapping("/view")
    public ModelAndView page(Customer customer) {

        ModelAndView modelAndView = new ModelAndView("balance");
        modelAndView.addObject("Customer", customerService.findCustomerByAccountNumber(customer.getAccNo()));
        return modelAndView;
    }

    @PostMapping("/depositfunds")
    public String deposit(CustomerDeposit customerDeposit, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Home";
        }

        Customer customer = customerService.findCustomerByAccountNumber(customerDeposit.getAccNumber());
        customer.setAccBalance((int) (customer.getAccBalance() + customerDeposit.getAmount()));
        depositService.addDeposit(customerDeposit);
        model.addAttribute("amount", customerDeposit.getAmount());

        return "depositSuccess";
    }

    @GetMapping("/deposit")
    public ModelAndView createdeposit(Model model, CustomerDeposit customerDeposit){

        return new ModelAndView("Deposit");
    }

    @GetMapping("/withdrawal")
    public ModelAndView withdrawal(Model model, Customer customer){

        return new ModelAndView("withdraw");
    }

    @PostMapping("/withdrawfunds")
    public String withdrawal(Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Home";
        }

        Customer customers = customerService.findCustomerByAccountNumber(customer.getAccNo());

        if(customers.getAccBalance() < customer.getAccBalance())
            return "You have insufficient funds";
        else {

            customers.setAccBalance((int) (customers.getAccBalance() - customer.getAccBalance()));
            customers.setAddress(customers.getAddress());
            model.addAttribute("amount", customer.getAccBalance());

            customerService.addCustomer(customers);

            return "withdrawalSuccess";
        }

    }


}
