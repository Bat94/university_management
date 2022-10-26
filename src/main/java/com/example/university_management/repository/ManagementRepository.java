package com.example.university_management.repository;

import com.example.university_management.entity.DMLop;
import com.example.university_management.entity.SinhVien_DMLopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ManagementRepository extends JpaRepository<SinhVien_DMLopEntity,Long> {

    List<SinhVien_DMLopEntity> findSinhVien_DMLopEntityByDmLopId(Long dmLop);


    @Query(nativeQuery = true, value = "SELECT *  FROM sinhvien_dmlop WHERE dm_lop_id = ?1")
    List<SinhVien_DMLopEntity> findSinhVien_DMLopEntityByDmLop2(Long dmLop);

    @Query(nativeQuery = true, value = "SELECT * FROM sinhvien_dmlop where sinh_vien_id = ?1")
    List<SinhVien_DMLopEntity> findSinhVien_DMLopEntityBySinhVienId(Long SinhVien);


    SinhVien_DMLopEntity findOneById(Long id);
}
