package com.persado.assignment.project.repository;

import com.persado.assignment.project.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

	List<Book> findBooksByAvailableGreaterThan(int available);

	@Query(value = "SELECT * FROM persado.book b WHERE b.available < b.purchased", nativeQuery = true)
	List<Book> findBooksByAvailableLessThanPurchased();
}
