package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Diary;
import com.example.demo.repository.DiaryRepository;
import com.example.demo.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @Autowired
    DiaryRepository diaryRepository;

    // 一覧取得
    @RequestMapping("/index")
    // @GetMapping("index")
    public String index(Model model) {

        List<Diary> diary = diaryService.diaryAll();
        model.addAttribute("diaryList", diary);

        return "diary/index";
    }

    // 削除
    // @RequestMapping("/delete")
    // public String delete(@RequestParam Integer id){
    //     diaryService.delete(id);
    // }

    //指定されたidの日記を削除する
    @PostMapping("delete")
    public String delete(@RequestParam String id) {
        diaryRepository.deleteById(id);
        return "redirect:/diary/summary";
    }
}
