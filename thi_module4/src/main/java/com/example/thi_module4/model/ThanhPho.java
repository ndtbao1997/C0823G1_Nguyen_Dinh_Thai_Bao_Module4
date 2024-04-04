package com.example.thi_module4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "thanhpho")

public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double dienTich;
    private Long danSo;
    private Long gdp;
    private String moTa;
    @ManyToOne
    @JoinColumn(name = "quocgia_id",referencedColumnName = "id")
    private QuocGia quocGia;

    public ThanhPho() {
    }

    public ThanhPho(Integer id, String name, Double dienTich, Long danSo, Long gdp, String moTa, QuocGia quocGia) {
        this.id = id;
        this.name = name;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.gdp = gdp;
        this.moTa = moTa;
        this.quocGia = quocGia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public Long getDanSo() {
        return danSo;
    }

    public void setDanSo(Long danSo) {
        this.danSo = danSo;
    }

    public Long getGdp() {
        return gdp;
    }

    public void setGdp(Long gdp) {
        this.gdp = gdp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }
}
