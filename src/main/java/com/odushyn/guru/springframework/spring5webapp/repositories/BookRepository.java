package com.odushyn.guru.springframework.spring5webapp.repositories;

import com.odushyn.guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {


}
