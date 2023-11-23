package com.keskin.productservice.controller;

import com.keskin.productservice.enums.Language;
import com.keskin.productservice.exception.enums.FriendlyMessageCodes;
import com.keskin.productservice.exception.utils.FriendlyMessageUtils;
import com.keskin.productservice.repository.entity.Product;
import com.keskin.productservice.request.ProductCreateRequest;
import com.keskin.productservice.response.FriendlyMessage;
import com.keskin.productservice.response.InternalApiResponse;
import com.keskin.productservice.response.ProductResponse;
import com.keskin.productservice.service.IProductRepositoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/1.0/product")
@RequiredArgsConstructor
class ProductController {
    private final IProductRepositoryService productRepositoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{language}/create")
    public InternalApiResponse<ProductResponse> createProduct(@PathVariable("language")Language language,
                                                              @RequestBody ProductCreateRequest productCreateRequest){
        log.debug("[{}][createProduct] -> request: {}",this.getClass().getSimpleName(),productCreateRequest);
        Product product = productRepositoryService.createProduct(language,productCreateRequest);
        ProductResponse productResponse = convertProductResponse(product);
        log.debug("[{}][createProduct] -> request: {}",this.getClass().getSimpleName(),productCreateRequest);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCodes.PRODUCT_SUCCESSFULLY_CREATED ))
                        .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();
    }

    private static ProductResponse convertProductResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .productCreatedDate(product.getProductCreatedDate().getTime())
                .productUpdatedDate(product.getProductUpdateDate().getTime())
                .productName(product.getProductName())
                .quantity(product.getQuality())
                .price(product.getPrice())
                .build();
    }
}
