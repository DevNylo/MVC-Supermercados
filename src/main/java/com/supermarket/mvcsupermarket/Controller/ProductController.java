package com.supermarket.mvcsupermarket.Controller;

import com.supermarket.mvcsupermarket.Entity.Product;
import com.supermarket.mvcsupermarket.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.listProduct();
        model.addAttribute("products", products);
        return "pages/produtos"; // Certifique-se de que este é o nome correto do template
    }

    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.salvarProduto(product);
        return "redirect:/products"; // Redirecionar após salvar
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam("query") String query, Model model) {
        List<Product> products = productService.searchProducts(query);
        model.addAttribute("products", products);
        return "pages/produtos"; // Certifique-se de que este é o nome correto do template
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        if (productService.deleteProduct(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
