package com.example.university_management.controller;

import com.example.university_management.entity.DMLop;
import com.example.university_management.entity.SinhVien_DMLopEntity;
import com.example.university_management.model.ManagementDto;
import com.example.university_management.service.IManagementService;
import com.example.university_management.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    @Autowired
    private IManagementService iManagementService;

    @PostMapping("/management/")
    public ResponseEntity<SinhVien_DMLopEntity> postManagement(@RequestBody ManagementDto managementDto){
        return managementService.postmanagement(managementDto);
    }

    @GetMapping("/management/")
    public ResponseEntity<List<SinhVien_DMLopEntity>> listManagement(){
        return managementService.listManagement();
    }

    @GetMapping("/management/{id}")
    public ResponseEntity<SinhVien_DMLopEntity> getManagement(@PathVariable(value = "id")Long id){
        return managementService.getManagement(id);
    }

    @GetMapping("/management/dm-lop/{dmLop}")
    public ResponseEntity<List<SinhVien_DMLopEntity>> getListManagementLop(@PathVariable(value = "dmLop")Long dmLop){
        return managementService.getManagementLop(dmLop);
    }

    @GetMapping("/management/sinh-vien/{sinhVien}")
    public ResponseEntity<List<SinhVien_DMLopEntity>> getListAllSinhVien(@PathVariable(value = "sinhVien")Long sinhVien){
        return iManagementService.getListSinhVien(sinhVien);
    }

    @PutMapping("/management/{id}")
    public ResponseEntity<SinhVien_DMLopEntity> update(@PathVariable(value = "id")Long id,@RequestBody ManagementDto managementDto){
        return iManagementService.update(id,managementDto);
    }

}
