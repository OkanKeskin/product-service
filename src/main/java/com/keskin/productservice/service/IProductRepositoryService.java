package com.keskin.productservice.service;

import com.keskin.productservice.enums.Language;
import com.keskin.productservice.repository.entity.Product;
import com.keskin.productservice.request.ProductCreateRequest;
import com.keskin.productservice.request.ProductUpdateRequest;

import java.util.List;

public interface IProductRepositoryService {

    Product createProduct(Language language, ProductCreateRequest productCreateRequest);
    Product getProduct(Language language, Long productId);
    List<Product> getProducts(Language language);
    Product updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest);
    Product deleteProduct(Language language,Long productId);



}
