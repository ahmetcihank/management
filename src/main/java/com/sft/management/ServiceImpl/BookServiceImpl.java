package com.sft.management.ServiceImpl;

import com.sft.management.Models.Book;
import com.sft.management.Repos.springRepo;
import com.sft.management.Services.BookServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookServiceI {

    @Autowired
    private com.sft.management.Repos.springRepo springRepo;


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
