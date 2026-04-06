package com.spring.mvc.jpa.controller;

import com.spring.mvc.jpa.model.Member;
import com.spring.mvc.jpa.repository.MemberRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepo;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("members", memberRepo.findAll());
        model.addAttribute("total", memberRepo.count());
        return "index";
    }

    @GetMapping("/add")
    public String showNewMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "add-member";
    }

    @PostMapping("/save")
    public String saveMember(@Valid @ModelAttribute("member") Member member, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-member";
        }
        memberRepo.save(member);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("status") String status, Model model) {
        model.addAttribute("members", memberRepo.findByPaymentStatus(status));
        model.addAttribute("total", memberRepo.count());
        return "index";
    }
}