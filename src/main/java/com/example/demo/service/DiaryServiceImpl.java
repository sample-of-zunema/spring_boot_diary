package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Diary;
import com.example.demo.repository.DiaryRepository;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    DiaryRepository diaryRepository;

    @Override
    public List<Diary> diaryAll() {

        List<Diary> allDiary = diaryRepository.findAll();

        return allDiary;
    }

}
