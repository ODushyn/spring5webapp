package com.odushyn.guru.springframework.spring5webapp.bootstrap;

import com.odushyn.guru.springframework.spring5webapp.model.Author;
import com.odushyn.guru.springframework.spring5webapp.model.Book;
import com.odushyn.guru.springframework.spring5webapp.model.Publisher;
import com.odushyn.guru.springframework.spring5webapp.repositories.AuthorRepository;
import com.odushyn.guru.springframework.spring5webapp.repositories.BookRepository;
import com.odushyn.guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBoostrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBoostrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "USA");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        ddd.getAuthors().add(eric);

        publisherRepository.save(harperCollins);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "USA");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(worx);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

    @Override public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
