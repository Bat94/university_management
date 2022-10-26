package com.example.university_management.controller;

import com.example.university_management.entity.SinhVien;
import com.example.university_management.model.SinhVienDto;
import com.example.university_management.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    @PostMapping("/sinh-vien/")
    public ResponseEntity<SinhVien> postSinhVien(@RequestBody SinhVienDto sinhVienDto){
        return sinhVienService.postSinhVien(sinhVienDto);
    }
}
