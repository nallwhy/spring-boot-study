package com.example.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  @RequestMapping("/")
  public String hello() {
    return "Hello, World!";
  }
}