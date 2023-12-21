package com.example.productmanagementapplication.repository;

import com.example.productmanagementapplication.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Bàn", 20000, "Bàn Japan", "Japan"));
        products.put(2, new Product(2, "Ghế", 21000, "Ghế Laos", "Laos"));
        products.put(3, new Product(3, "Tủ", 22000, "Tủ Korea", "Korea"));
        products.put(4, new Product(4, "Dao", 23000, "Dao Thailand", "Thailand"));
        products.put(5, new Product(5, "Kéo", 24000, "Kéo Campuchia", "Campuchia"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public boolean checkId(int id) {
        return products.get(id) != null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products1 = findAll();
        List<Product> products2 = new ArrayList<>();
        for (Product product:products1){
            if (product.getName().toLowerCase().contains(name.toLowerCase())){
                products2.add(product);
            }
        }
        return products2;
    }
}
