package com.example.validate_song_information.controller;

import com.example.validate_song_information.model.Song;
import com.example.validate_song_information.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @ModelAttribute("songs")
    public Iterable<Song> listSong(){
        return iSongService.findAll();
    }

    @GetMapping("")
    public ModelAndView showHome(){
        return new ModelAndView("index","songs",iSongService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create","song",new Song());
    }

    @PostMapping("/create")
    public String createSong(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("songs",iSongService.findAll());
            return "redirect:/";
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Integer id){
        Optional<Song> song = iSongService.findById(id);
        if (song.isPresent()){
            return new ModelAndView("update","song",song.get());
        } else {
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("songs",iSongService.findAll());
            modelAndView.addObject("message","Đã có lỗi xảy ra!!!");
            return modelAndView;
        }
    }

    @PostMapping("/update/{id}")
    public String updateSong(@Validated @ModelAttribute("song") Song song,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            return "update";
        } else {
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("message","Bạn đã cập nhật thành công");
            return "redirect:/";
        }
    }
}
