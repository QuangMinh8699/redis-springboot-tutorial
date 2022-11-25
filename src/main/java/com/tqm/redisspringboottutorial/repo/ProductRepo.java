package com.tqm.redisspringboottutorial.repo;

import com.tqm.redisspringboottutorial.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate template;

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(Long id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(Long id) {
        template.opsForHash().delete(HASH_KEY, id);
        return  "Product Removed !";
    }
}
