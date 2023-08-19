package com.example.RegistroUsuariosApplication.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService userService;

    @Autowired
    public ProductController(ProductService userService) {
        this.userService = userService;
    }

    @GetMapping

    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = userService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> crearUser(@RequestBody Products user) {
        return userService.createProduct(user);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarUser(@RequestBody Products user) {
        return userService.updateProduct(user);
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<Object> eliminarUser(@PathVariable("userId") Long userId) {
        return userService.deleteProduct(userId);
    }

}