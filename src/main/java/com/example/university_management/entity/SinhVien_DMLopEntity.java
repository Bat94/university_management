package com.example.university_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "sinhvien_dmlop")
public class SinhVien_DMLopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "sinh_vien_id",referencedColumnName = "id")
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "dm_lop_id",referencedColumnName = "id")
//    @JsonIgnore
    private DMLop dmLop;
}
