package com.example.university_management.service;

import com.example.university_management.entity.DMLop;
import com.example.university_management.model.DMLopDto;
import com.example.university_management.repository.DMLopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DMLopService {

    @Autowired
    private DMLopRepository dmLopRepository;

    public ResponseEntity<DMLop> postLop(DMLopDto dmLopDto) {
        DMLop dmLop = new DMLop();
        dmLop.setTenLop(dmLopDto.getTenLop());
        dmLop.setKhoaHoc(dmLopDto.getKhoaHoc());
        dmLop.setNganhId(dmLopDto.getNganhId());
        dmLop.setNamNhapHoc(dmLopDto.getNamNhapHoc());
        dmLop.setHeDT(dmLopDto.getHeDT());
        dmLopRepository.save(dmLop);
        return ResponseEntity.ok(dmLop);
    }
}
