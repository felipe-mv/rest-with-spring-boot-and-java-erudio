package br.com.innmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.innmanager.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>{}
