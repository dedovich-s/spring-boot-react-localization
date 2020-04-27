package com.dedovich.localization.data.repository;

import com.dedovich.localization.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
