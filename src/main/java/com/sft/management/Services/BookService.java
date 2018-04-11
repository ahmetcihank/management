package com.sft.management.Services;


import com.sft.management.Models.Book;
import com.sft.management.Repos.springRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private springRepo springRepo;


    public List<Book> findAllBooks(){
        List<Book> books = new ArrayList<Book>();
        for(Book book: springRepo.findAll())
        {
            books.add(book);
        }
        return books;
    }

    public void deleteBook(long id)
    {
        springRepo.deleteById(id);
    }

    public void saveBook(Book book)
    {
        springRepo.save(book);
    }

}
