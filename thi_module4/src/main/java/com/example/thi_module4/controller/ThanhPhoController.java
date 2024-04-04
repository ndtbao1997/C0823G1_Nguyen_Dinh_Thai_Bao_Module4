package com.example.thi_module4.controller;

import com.example.thi_module4.dto.IThanhPhoDTO;
import com.example.thi_module4.dto.ThanhPhoDTO;
import com.example.thi_module4.model.QuocGia;
import com.example.thi_module4.model.ThanhPho;
import com.example.thi_module4.repository.IThanhPhoRepository;
import com.example.thi_module4.service.IQuocGiaService;
import com.example.thi_module4.service.IThanhPhoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class ThanhPhoController {
    @Autowired
    private IThanhPhoService iThanhPhoService;
    @Autowired
    private IQuocGiaService iQuocGiaService;
    @ModelAttribute("listQuocGia")
    public List<QuocGia> getListQuocGia(){
        return (List<QuocGia>) iQuocGiaService.findAll();
    }

    @GetMapping("/")
    public ModelAndView showHome() {
        List<IThanhPhoDTO> iThanhPhoDTOS = (List<IThanhPhoDTO>) iThanhPhoService.getListThanhPhoDTO();
        return new ModelAndView("list-thanh-pho", "listThanhPho", iThanhPhoDTOS);
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        List<QuocGia> quocGias = (List<QuocGia>) iQuocGiaService.findAll();
        ModelAndView modelAndView = new ModelAndView("create-thanh-pho");
        modelAndView.addObject("thanhPho", new ThanhPhoDTO());
        modelAndView.addObject("listQuocGia", quocGias);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Valid @ModelAttribute("thanhPho") ThanhPhoDTO thanhPho, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("create-thanh-pho");
        }
        ThanhPho thanhPho1 = new ThanhPho();
        BeanUtils.copyProperties(thanhPho, thanhPho1);
        iThanhPhoService.save(thanhPho1);
        ModelAndView modelAndView = new ModelAndView("list-thanh-pho");
        List<IThanhPhoDTO> iThanhPhoDTOS = (List<IThanhPhoDTO>) iThanhPhoService.getListThanhPhoDTO();
        modelAndView.addObject("listThanhPho", iThanhPhoDTOS);
        modelAndView.addObject("success", "Bạn đã thêm mới thành công");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable Integer id) {
        Optional<ThanhPho> thanhPho = iThanhPhoService.findById(id);
        if (!thanhPho.isPresent()) {
            return new ModelAndView("error");
        }
        return new ModelAndView("view-thanh-pho", "thanhPho", thanhPho.get());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEditCity(@PathVariable Integer id) {
        Optional<ThanhPho> thanhPho = iThanhPhoService.findById(id);
        if (!thanhPho.isPresent()) {
            return new ModelAndView("error");
        }
        ThanhPhoDTO thanhPhoDTO = new ThanhPhoDTO();
        BeanUtils.copyProperties(thanhPho.get(),thanhPhoDTO);
        ModelAndView modelAndView = new ModelAndView("edit-thanh-pho");
        modelAndView.addObject("thanhPho", thanhPhoDTO);
        List<QuocGia> quocGias = (List<QuocGia>) iQuocGiaService.findAll();
        modelAndView.addObject("listQuocGia", quocGias);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editCity(@Valid @ModelAttribute("thanhPho") ThanhPhoDTO thanhPho, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("edit-thanh-pho");
        }
        ThanhPho thanhPho1 = new ThanhPho();
        BeanUtils.copyProperties(thanhPho, thanhPho1);
        iThanhPhoService.save(thanhPho1);
        ModelAndView modelAndView = new ModelAndView("list-thanh-pho");
        List<IThanhPhoDTO> iThanhPhoDTOS = (List<IThanhPhoDTO>) iThanhPhoService.getListThanhPhoDTO();
        modelAndView.addObject("listThanhPho", iThanhPhoDTOS);
        modelAndView.addObject("success", "Bạn đã sửa thành công");
        return modelAndView;
    }

    @PostMapping("/remove")
    public String removeCity(@RequestParam("idDelete") Integer idDelete, RedirectAttributes redirectAttributes) {
        iThanhPhoService.deleteById(idDelete);
        redirectAttributes.addFlashAttribute("success", "Bạn đã xóa thành phố thành công");
        return "redirect:/";
    }
}
