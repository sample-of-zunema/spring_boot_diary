package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diary")
public class Diary {

    public Diary(String bodytext, LocalDateTime createDatetime) {
        this.bodytext = bodytext;
        this.createDatetime = createDatetime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String bodytext;

    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime createDatetime;
}
