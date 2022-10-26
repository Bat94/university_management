package com.example.university_management.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class SinhVienDto {

    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
}
