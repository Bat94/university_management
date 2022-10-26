package com.example.university_management.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DMLopDto {
    private String tenLop;
    private long nganhId;
    private String khoaHoc;
    private String heDT;
    private Date namNhapHoc;
}
