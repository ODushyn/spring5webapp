package com.odushyn.guru.springframework.spring5webapp;

import com.odushyn.guru.springframework.spring5webapp.model.Author;
import com.odushyn.guru.springframework.spring5webapp.model.Book;

public class DevBootstrap {

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "234444", "Worx");
        rod.getBooks().add(noEJB);
    }
}
