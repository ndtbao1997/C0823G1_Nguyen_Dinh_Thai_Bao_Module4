package com.example.product_management.repository;

import com.example.product_management.dto.IProductDTO;
import com.example.product_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select product.id as id,\n" +
            "product.name as name,\n" +
            "product.price as price,\n" +
            "product.quantity as quantity,\n" +
            "product.image as image,\n" +
            "category.name as categoryName \n" +
            "from product left join category on product.category_id = category.id;",nativeQuery = true)
    Page<IProductDTO> findAllDTO(Pageable pageable);
}
