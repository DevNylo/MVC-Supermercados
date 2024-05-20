package com.supermarket.mvcsupermarket.Service;

import com.supermarket.mvcsupermarket.Entity.Product;
import com.supermarket.mvcsupermarket.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public boolean deleteProduct(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public List<Product> searchProducts(String query) {
        try {
            int id = Integer.parseInt(query);
            Product product = productRepository.findById(id);
            if (product != null) {
                return Collections.singletonList(product);
            } else {
                return Collections.emptyList();
            }
        } catch (NumberFormatException e) {
            return productRepository.findByNomeContainingIgnoreCaseOrDescricaoContainingIgnoreCase(query, query);
        }
    }
}
