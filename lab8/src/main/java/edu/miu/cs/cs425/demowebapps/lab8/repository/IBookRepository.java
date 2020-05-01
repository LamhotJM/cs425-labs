package edu.miu.cs.cs425.demowebapps.lab8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.demowebapps.lab8.model.Book;

@Repository
public interface IBookRepository extends CrudRepository<Book,Long>{

}
