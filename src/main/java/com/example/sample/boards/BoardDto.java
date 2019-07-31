package com.example.sample.boards;

import java.time.LocalTime;

import lombok.Data;

@Data
public class BoardDto {
  private int id;
  private String title;
  private String content;
  private int hitCount;
  private String createdBy;
  private String updatedBy;
  private LocalTime createdAt;
  private LocalTime updatedAt;
}