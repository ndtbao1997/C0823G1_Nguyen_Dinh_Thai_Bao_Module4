package com.example.thi_module4.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "quocgia")
public class QuocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "quocGia")
    private List<ThanhPho> thanhPhoList;

    public QuocGia() {
    }

    public QuocGia(Integer id, String name, List<ThanhPho> thanhPhoList) {
        this.id = id;
        this.name = name;
        this.thanhPhoList = thanhPhoList;
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

    public List<ThanhPho> getThanhPhoList() {
        return thanhPhoList;
    }

    public void setThanhPhoList(List<ThanhPho> thanhPhoList) {
        this.thanhPhoList = thanhPhoList;
    }
}
