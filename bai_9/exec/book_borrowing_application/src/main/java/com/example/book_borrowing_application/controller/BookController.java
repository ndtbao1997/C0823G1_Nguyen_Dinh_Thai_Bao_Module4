package com.example.book_borrowing_application.controller;

import com.example.book_borrowing_application.dto.UserDto;
import com.example.book_borrowing_application.model.Book;
import com.example.book_borrowing_application.model.BookDetails;
import com.example.book_borrowing_application.model.User;
import com.example.book_borrowing_application.service.IBookDetailsService;
import com.example.book_borrowing_application.service.IBookService;
import com.example.book_borrowing_application.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IBookDetailsService iBookDetailsService;


    @GetMapping("")
    public ModelAndView showBookHome() {
        return new ModelAndView("book-home", "books", iBookService.findAll());
    }

    @GetMapping("/borrow")
    public ModelAndView showFormBorrow(@RequestParam("idBorrow") Integer idBorrow) {
        ModelAndView modelAndView = new ModelAndView("borrow-form");
        modelAndView.addObject("userDto", new UserDto());
        modelAndView.addObject("idBorrow", idBorrow);
        return modelAndView;
    }

    @PostMapping("/borrow/{idB}")
    public String getBorrow(@Valid @ModelAttribute("userDto") UserDto user,
                            BindingResult bindingResult,
                            @PathVariable Integer idB,
                            Model model,
                            RedirectAttributes redirectAttributes) throws Exception{
        if (bindingResult.hasErrors()) {
            model.addAttribute("idBorrow", idB);
            return "borrow-form";
        }
        UserDto user1 = iUserService.setUser(user);
        User user2 = new User();
        BeanUtils.copyProperties(user1,user2);
        iUserService.save(user2);
        Optional<Book> book = iBookService.findById(idB);
        if (book.isPresent()) {
            Book book1 = book.get();
            book1.setQuantity(book1.getQuantity() - 1);
            iBookService.save(book1);
            BookDetails bookDetails = new BookDetails();
            bookDetails.setDateTime(LocalDateTime.now());
            bookDetails.setBook(book1);
            bookDetails.setUser(user2);
            String randomCode = getRandomCode();
            bookDetails.setRandomCode(randomCode);
            iBookDetailsService.save(bookDetails);
            redirectAttributes.addFlashAttribute("success","Đã mượn sách thành công!!! Mã mượn sách của bạn là " + randomCode);
            return "redirect:/";
        } else {
            throw new RuntimeException();
        }
    }

    private String getRandomCode() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000;
        return String.valueOf(randomNumber);
    }
}
