package com.example.university_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dm_lop")
public class DMLop {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ten_lop")
    private String tenLop;

    @Column(name = "nganh_id")
    private long nganhId;

    @Column(name = "khoa_hoc")
    private String khoaHoc;

    @Column(name = "he_dt")
    private String heDT;

    @Column(name = "nam_nhap_hoc")
    private Date namNhapHoc;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "dmLop",cascade = CascadeType.ALL)
    private Collection<SinhVien_DMLopEntity> sinhVien_dmLopEntities;

    public Collection<SinhVien_DMLopEntity> getSinhVien_dmLopEntities() {
        return sinhVien_dmLopEntities;
    }

    public void setSinhVien_dmLopEntities(Collection<SinhVien_DMLopEntity> sinhVien_dmLopEntities) {
        this.sinhVien_dmLopEntities = sinhVien_dmLopEntities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public long getNganhId() {
        return nganhId;
    }

    public void setNganhId(long nganhId) {
        this.nganhId = nganhId;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getHeDT() {
        return heDT;
    }

    public void setHeDT(String heDT) {
        this.heDT = heDT;
    }

    public Date getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(Date namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }
}
