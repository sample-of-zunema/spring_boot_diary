package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DiaryForm;
import com.example.demo.entity.Diary;
import com.example.demo.repository.DiaryRepository;
import com.example.demo.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    // 一覧取得
    @RequestMapping("/index")
    // @GetMapping("index")
    public String index(Model model) {

        List<Diary> diary = diaryService.diaryAll();
        model.addAttribute("diaryList", diary);

        return "diary/index";
    }

    /**
     * 日記情報詳細画面を表示
     * @param id 表示する投稿ID
     * @param model Model
     * @return 投稿情報詳細画面
     */
    @GetMapping("/diary/{id}")
    public String displayView(@PathVariable Long id, Model model) {
        Diary diary = diaryService.findById(id);
        model.addAttribute("diaryData", diary);
        return "diary/view";
    }

}
