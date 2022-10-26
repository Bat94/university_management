package com.example.university_management.service;

import com.example.university_management.entity.DMLop;
import com.example.university_management.entity.SinhVien;
import com.example.university_management.entity.SinhVien_DMLopEntity;
import com.example.university_management.model.ManagementDto;
import com.example.university_management.repository.DMLopRepository;
import com.example.university_management.repository.ManagementRepository;
import com.example.university_management.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagementService implements IManagementService {
    @Autowired
    private ManagementRepository managementRepository;

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private DMLopRepository dmLopRepository;

    public ResponseEntity<List<SinhVien_DMLopEntity>> listManagement() {
        List<SinhVien_DMLopEntity> listManagementAll = managementRepository.findAll();
        if(listManagementAll.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listManagementAll);
    }

    public ResponseEntity<SinhVien_DMLopEntity> postmanagement(ManagementDto managementDto) {
        Optional<SinhVien> sinhVien = sinhVienRepository.findById(managementDto.getSinhVien());
        Optional<DMLop> dmLop = dmLopRepository.findById(managementDto.getDmLop());
        if(sinhVien.isEmpty()||dmLop.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        SinhVien_DMLopEntity sinhVien_dmLopEntity = new SinhVien_DMLopEntity();
        sinhVien_dmLopEntity.setSinhVien(sinhVien.get());
        sinhVien_dmLopEntity.setDmLop(dmLop.get());
        managementRepository.save(sinhVien_dmLopEntity);
        return ResponseEntity.ok(sinhVien_dmLopEntity);
    }

    public ResponseEntity<SinhVien_DMLopEntity> getManagement(Long id) {
        SinhVien_DMLopEntity sinhVien_dmLopEntity = managementRepository.findOneById(id);
        if(sinhVien_dmLopEntity == null){
            return ResponseEntity.notFound().build();
        }
            return new ResponseEntity<>(sinhVien_dmLopEntity, HttpStatus.OK);
    }


    public ResponseEntity<List<SinhVien_DMLopEntity>> getManagementLop(Long dmLop) {

        if(!dmLopRepository.existsById(dmLop)){
            return ResponseEntity.notFound().build();
        }
        List<SinhVien_DMLopEntity> sinhVien_dmLopEntity = managementRepository.findSinhVien_DMLopEntityByDmLopId(dmLop);
        return new ResponseEntity<>(sinhVien_dmLopEntity,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<SinhVien_DMLopEntity>> getListSinhVien(Long sinhVien) {
        List<SinhVien_DMLopEntity> sinhVien_dmLopEntities = managementRepository.findSinhVien_DMLopEntityBySinhVienId(sinhVien);
        if(sinhVien_dmLopEntities.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(sinhVien_dmLopEntities,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SinhVien_DMLopEntity> update(Long id,ManagementDto managementDto) {
        SinhVien_DMLopEntity sinhVien_dmLopEntity = managementRepository.findOneById(id);
        if(sinhVien_dmLopEntity == null) {
            return ResponseEntity.notFound().build();
        }
            Optional<SinhVien> sinhVien = sinhVienRepository.findById(managementDto.getSinhVien());
            if(sinhVien.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            sinhVien_dmLopEntity.setSinhVien(sinhVien.get());
            SinhVien_DMLopEntity update =managementRepository.save(sinhVien_dmLopEntity);
            return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SinhVien_DMLopEntity> deleteSinhVien_DmLop(Long id) {
        SinhVien_DMLopEntity sinhVien_dmLopEntity = managementRepository.findOneById(id);
            if(sinhVien_dmLopEntity == null){
                return ResponseEntity.notFound().build();
            }
            managementRepository.delete(sinhVien_dmLopEntity);
            return ResponseEntity.ok().build();
    }
}
