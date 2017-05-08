package edu.umbc.yhuang9.controller;

import edu.umbc.yhuang9.fileentity.Product;
import edu.umbc.yhuang9.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Created by yhuang9 on 5/8/17.
 */
@Controller
public class ProductController {
    private ProductServiceImpl productServiceImpl;

    @Autowired
    public void setProductService(ProductServiceImpl productServiceImpl){
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping(value = "/products")
    public String list(Model model){
        model.addAttribute("products", productServiceImpl.listAllProducts());
        System.out.println("Returning products:");
        return "products";
    }

    @GetMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productServiceImpl.getProductById(id));
        return "productshow";
    }

    @GetMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productServiceImpl.getProductById(id));
        return "productform";
    }

    @GetMapping("product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @PostMapping(value = "product")
    public String saveProduct(Product product){

        productServiceImpl.saveProduct(product);

        return "redirect:/product/" + product.getId();
    }

}
