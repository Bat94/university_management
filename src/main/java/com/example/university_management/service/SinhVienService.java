package com.example.university_management.service;

import com.example.university_management.entity.SinhVien;
import com.example.university_management.model.SinhVienDto;
import com.example.university_management.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;

    public ResponseEntity<SinhVien> postSinhVien(SinhVienDto sinhVienDto) {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setHoTen(sinhVienDto.getHoTen());
        sinhVien.setNgaySinh(sinhVienDto.getNgaySinh());
        sinhVien.setGioiTinh(sinhVienDto.isGioiTinh());
        sinhVien.setDiaChi(sinhVienDto.getDiaChi());
        sinhVienRepository.save(sinhVien);
        return ResponseEntity.ok(sinhVien);
    }
}
