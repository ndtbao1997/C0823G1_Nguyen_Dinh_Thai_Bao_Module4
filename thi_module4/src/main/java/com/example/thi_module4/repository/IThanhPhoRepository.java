package com.example.thi_module4.repository;

import com.example.thi_module4.dto.IThanhPhoDTO;
import com.example.thi_module4.model.ThanhPho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IThanhPhoRepository extends JpaRepository<ThanhPho,Integer> {
    @Query(value = "select thanhpho.id as id,\n" +
            "thanhpho.name as nameThanhPho,\n" +
            "quocgia.name as nameQuocGia \n" +
            "from thanhpho join quocgia on thanhpho.quocgia_id = quocgia.id;",nativeQuery = true)
    Iterable<IThanhPhoDTO> getListThanhPhoDTO();
}
