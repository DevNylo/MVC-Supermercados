package com.supermarket.mvcsupermarket.Controller;

import com.supermarket.mvcsupermarket.Entity.Product;
import com.supermarket.mvcsupermarket.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class AddProductCommand {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.salvarProduto(product);
        return "redirect:/products";
    }
}
