package com.example.spring.guru.demo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	public Author() {
	}

	public Author(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author(final String firstName, final String lastName, final Set<Book> books) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(final Set<Book> books) {
		this.books = books;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Author author = (Author) o;
		return id.equals(author.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Author{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", books=" + books
				+ '}';
	}
}
