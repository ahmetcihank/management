package com.sft.management.Controller;



import com.sft.management.Models.Book;
import com.sft.management.Models.Managers;
import com.sft.management.ServiceImpl.BookServiceImpl;
import com.sft.management.ServiceImpl.ManagementServiceImpl;
import com.sft.management.Services.BookService;
import com.sft.management.Services.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class rController {

    @Autowired
    private BookServiceImpl bookServiceImpl;
    @Autowired
    private ManagementServiceImpl managementServiceImpl ;

   // @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/getAll")
    public Collection<Book> getAllBooks()
    {
      return  bookServiceImpl.findAllBooks();

    }

    @GetMapping("/deletebook")
    public Collection<Book> deleteBook(@RequestParam long id) throws InterruptedException
    {

        bookServiceImpl.deleteBook(id);
        Thread.sleep(1000);
        return  bookServiceImpl.findAllBooks();
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/saveBook")
    public Collection<Book> saveBook(@RequestParam String bookName, String author, String purchaseDate) throws InterruptedException
    {

        Book book = new Book( bookName,author,new Date());

        bookServiceImpl.saveBook(book);
        Thread.sleep(1000);
        return  bookServiceImpl.findAllBooks();
    }

    @GetMapping("/getmanagers")
    public Collection<Managers> getAllManagers()
    {
        return  managementServiceImpl.findAllManagers();

    }

    @GetMapping("/saveManagers")
    public Collection<Managers> saveManagers(@RequestParam String managerName,@RequestParam String managerTitle) throws InterruptedException
    {
        Managers manager = new Managers(managerName,managerTitle, null);
        managementServiceImpl.saveManagers(manager);
        Thread.sleep(1000);
        return managementServiceImpl.findAllManagers();

    }

    @GetMapping("/deleteManagers")
    public Collection<Managers> deleteManagers(@RequestParam Long id) throws InterruptedException
    {
        managementServiceImpl.deleteManagers(id);
        Thread.sleep(1000);
        return managementServiceImpl.findAllManagers();
    }

}
