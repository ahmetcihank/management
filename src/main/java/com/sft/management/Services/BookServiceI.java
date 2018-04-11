package com.sft.management.Services;

import com.sft.management.Models.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookServiceI
{
    public List<Book> findAllBooks();

    public void deleteBook(long id);
    public void saveBook(Book book);

}
