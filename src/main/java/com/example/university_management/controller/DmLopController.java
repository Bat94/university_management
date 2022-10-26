package com.example.university_management.controller;

import com.example.university_management.entity.DMLop;
import com.example.university_management.model.DMLopDto;
import com.example.university_management.service.DMLopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DmLopController {
    @Autowired
    private DMLopService dmLopService;

    @PostMapping("/dm-lop/")
    public ResponseEntity<DMLop> postLop(@RequestBody DMLopDto dmLopDto){
        return dmLopService.postLop(dmLopDto);
    }

    @GetMapping("/dm-lop/")
    public ResponseEntity<List<DMLop>> getDmLop(){
        return dmLopService.getAll();
    }
}
