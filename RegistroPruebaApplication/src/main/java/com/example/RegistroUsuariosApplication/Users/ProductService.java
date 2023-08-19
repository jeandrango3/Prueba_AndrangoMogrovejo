//UserService
package com.example.RegistroUsuariosApplication.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> getProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<Object> createProduct(Products product) {
        Optional<Products> existingProduct = productRepository.findProductsByName(product.getName());
        HashMap<String, Object> data = new HashMap<>();

        if (existingProduct.isPresent()) {
            data.put("data", false);
            data.put("message", "El producto ya existe");
            return new ResponseEntity<>(data, HttpStatus.CONFLICT);
        } else {
            Products savedProduct = productRepository.save(product);
            data.put("data", savedProduct);
            data.put("message", "Producto creado");

            return new ResponseEntity<>(data, HttpStatus.CREATED);
        }
    }
    public ResponseEntity<Object> updateProduct(Products product) {
        Optional<Products> existingProduct = productRepository.findById(product.getId());
        HashMap<String, Object> datos = new HashMap<>();

        if (existingProduct.isPresent()) {
            Products savedProduct = productRepository.save(product);
            datos.put("data", savedProduct);
            datos.put("message", "Producto actualizado");

            return new ResponseEntity<>(datos, HttpStatus.OK);
        } else {
            datos.put("data", false);
            datos.put("message", "El producto con ID " + product.getId() + " no existe");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Object> deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        HashMap<String, Object> datos = new HashMap<>();

        if (!exists) {
            datos.put("data", false);
            datos.put("message", "El producto con id " + productId + " no existe");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        productRepository.deleteById(productId);
        datos.put("data", true);
        datos.put("message", "El producto con id " + productId + " ha sido eliminado");
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }
}