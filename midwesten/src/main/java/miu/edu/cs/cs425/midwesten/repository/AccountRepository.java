package miu.edu.cs.cs425.midwesten.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import miu.edu.cs.cs425.midwesten.model.Account;
import miu.edu.cs.cs425.midwesten.model.Customer;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

   
}
