package com.qspiders.BankingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspiders.BankingApplication.Dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
