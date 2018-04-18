package com.sft.management.Controller;


import com.sft.management.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class mController {

   @Autowired
   private BookService bookService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value="/")
    public String init(/*HttpServletRequest request */){

       // request.setAttribute("books", bookService.findAllBooks());
        return "index";

}
}
