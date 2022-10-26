package com.example.university_management.service;


import com.example.university_management.entity.SinhVien_DMLopEntity;
import com.example.university_management.model.ManagementDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IManagementService {
    ResponseEntity<List<SinhVien_DMLopEntity>> getListSinhVien(Long sinhVien);

    ResponseEntity<SinhVien_DMLopEntity> update(Long id,ManagementDto managementDto);
}
