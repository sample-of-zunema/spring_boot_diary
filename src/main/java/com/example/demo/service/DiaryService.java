package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Diary;

@Service
public interface DiaryService {

    List<Diary> diaryAll();
}
