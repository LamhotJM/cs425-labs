package edu.miu.cs.cs425.demowebapps.lab8;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.demowebapps.lab8.model.Book;
import edu.miu.cs.cs425.demowebapps.lab8.repository.IBookRepository;

@SpringBootApplication
public class Lab8Application implements CommandLineRunner {
	 

	@Autowired
	private IBookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Lab8Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		System.out.println("Generate book");
		Book book1= new Book("Java Project", LocalDate.of(1992, 3,3));
		Book saveBook1 =bookRepository.save(book1);
		System.out.println(saveBook1);
		//getListOfBook().forEach(System.out::println);
		
	}
	
	private Iterable<Book> getListOfBook()
	{
		return bookRepository.findAll();
	}
	

}
