package com.example.book_borrowing_application.controller;

import com.example.book_borrowing_application.dto.BookDetailsDto;
import com.example.book_borrowing_application.dto.IBookDetailsDto;
import com.example.book_borrowing_application.model.Book;
import com.example.book_borrowing_application.model.BookDetails;
import com.example.book_borrowing_application.service.IBookDetailsService;
import com.example.book_borrowing_application.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book-detail")
public class BookDetailsController{
    @Autowired
    private IBookDetailsService iBookDetailsService;

    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public ModelAndView showListBorrow(){
        List<IBookDetailsDto> iBookDetailsDtos = iBookDetailsService.getListBookDetailsDto();
        ModelAndView modelAndView = new ModelAndView("borrow-list","listBorrow",iBookDetailsDtos);
        modelAndView.addObject("df", DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"));
        return modelAndView;
    }

    @GetMapping("/pay")
    public String payBook(@RequestParam("idPay") Integer idPay,
                          @RequestParam("randomCode") String randomCode,
                          RedirectAttributes redirectAttributes) throws Exception{
        boolean checkRDCode = iBookDetailsService.checkRandomCode(idPay,randomCode);
        if (checkRDCode){
            Optional<BookDetails> bookDetails = iBookDetailsService.findById(idPay);
            if (bookDetails.isPresent()){
                Book book = bookDetails.get().getBook();
                book.setQuantity(book.getQuantity()+1);
                iBookService.save(book);
                iBookDetailsService.remove(idPay);
                redirectAttributes.addFlashAttribute("success","Bạn đã trả sách thành công!!!");
                return "redirect:/";
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }
    }
}
