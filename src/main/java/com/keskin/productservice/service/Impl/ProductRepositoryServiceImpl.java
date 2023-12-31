package com.keskin.productservice.service.Impl;

import com.keskin.productservice.enums.Language;
import com.keskin.productservice.exception.enums.FriendlyMessageCodes;
import com.keskin.productservice.exception.exceptions.ProductNotCreatedException;
import com.keskin.productservice.repository.ProductRepository;
import com.keskin.productservice.repository.entity.Product;
import com.keskin.productservice.request.ProductCreateRequest;
import com.keskin.productservice.request.ProductUpdateRequest;
import com.keskin.productservice.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductRepositoryServiceImpl implements IProductRepositoryService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Language language, ProductCreateRequest productCreateRequest) {
        log.debug("[{}][createProduct] -> request: {}",this.getClass().getSimpleName(),productCreateRequest);
        try{
            Product product = Product.builder()
                    .productName(productCreateRequest.getProductName())
                    .quality(productCreateRequest.getQuantity())
                    .price(productCreateRequest.getPrice())
                    .deleted(false)
                    .build();
            Product productResponse = productRepository.save(product);
            log.debug("[{}][createProduct] -> response: {}",this.getClass().getSimpleName(),productResponse);
            return productResponse;
        }
        catch (Exception exception){
            throw new ProductNotCreatedException(language, FriendlyMessageCodes.PRODUCT_NOT_CREATED_EXCEPTION,"Product Request: " + productCreateRequest.toString());
        }
    }

    @Override
    public Product getProduct(Language language, Long productId) {
        return null;
    }

    @Override
    public List<Product> getProducts(Language language) {
        return null;
    }

    @Override
    public Product updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest) {
        return null;
    }

    @Override
    public Product deleteProduct(Language language, Long productId) {
        return null;
    }
}
