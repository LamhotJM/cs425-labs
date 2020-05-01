package edu.mum.cs.cs425.demowebapps.elibrary.repository;

import edu.mum.cs.cs425.demowebapps.elibrary.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
