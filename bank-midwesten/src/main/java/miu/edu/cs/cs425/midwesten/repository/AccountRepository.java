package miu.edu.cs.cs425.midwesten.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import miu.edu.cs.cs425.midwesten.model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
