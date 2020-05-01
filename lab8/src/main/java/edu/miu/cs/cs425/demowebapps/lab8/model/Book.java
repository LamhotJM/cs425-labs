package edu.miu.cs.cs425.demowebapps.lab8.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookId; // big integer@
	@Column(nullable=false)
	private String title; // varchar
	private LocalDate publishDate;
	//private Boolean bestSeller;
	

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(long bookId, String title, LocalDate publishDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publishDate = publishDate;
	}



	public Book(String title, LocalDate publishDate) {
		this.title = title;
		this.publishDate = publishDate;
	}


	public long getBookId() {
		return bookId;
	}


	public void setBookId(long bookId) {
		this.bookId = bookId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public LocalDate getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}


	@Override
	public String toString() {
		return String.format("Book [bookId=%s, title=%s, publishDate=%s]", bookId, title, publishDate);
	}


	

}
