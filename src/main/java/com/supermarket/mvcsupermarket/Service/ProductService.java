package com.supermarket.mvcsupermarket.Service;

import com.supermarket.mvcsupermarket.Entity.Product;
import com.supermarket.mvcsupermarket.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    public void salvarProduto(Product product) {
        productRepository.save(product);
    }
}
