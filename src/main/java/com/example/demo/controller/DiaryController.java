package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Diary;
import com.example.demo.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @RequestMapping("/index")
    public String index(Model model) {

        List<Diary> diary = diaryService.diaryAll();
        model.addAttribute("diaryList", diary);

        return "diary/index";
    }
}
