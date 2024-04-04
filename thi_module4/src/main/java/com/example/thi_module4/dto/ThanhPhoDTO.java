package com.example.thi_module4.dto;

import com.example.thi_module4.model.QuocGia;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ThanhPhoDTO {
    private Integer id;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 30 ,message = "Tên phải có độ dài tối đa 30 kí tự")
    private String name;
    @Min(value = 1,message = "Diện tích phải là số dương")
    private Double dienTich;
    @Min(value = 1,message = "Dân số phải là số dương")
    private Long danSo;
    @Min(value = 1,message = "GDP phải là số dương")
    private Long gdp;

    @NotBlank(message = "Mô tả không được để trống")
    @Size(min = 10,max = 40 ,message = "Mô tả phải có độ dài tối thiểu 30 và tối đa 40 kí tự")
    private String moTa;

    private QuocGia quocGia;

    public ThanhPhoDTO(Integer id, String name, Double dienTich, Long danSo, Long gdp, String moTa, QuocGia quocGia) {
        this.id = id;
        this.name = name;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.gdp = gdp;
        this.moTa = moTa;
        this.quocGia = quocGia;
    }

    public ThanhPhoDTO() {
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
