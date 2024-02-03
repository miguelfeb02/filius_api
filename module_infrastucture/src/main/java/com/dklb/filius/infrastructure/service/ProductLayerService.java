package com.dklb.filius.infrastructure.service;

import aplication.service.ProductAppService;
import com.dklb.filius.infrastructure.helpers.models.request.ProductRequest.ProductRequest;
import domain.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductLayerService {

    @Autowired
    private ProductAppService productAppService;

    ModelMapper modelMapper=new ModelMapper();

    public List<Product> getProductsByBusinnesId(String businessId){
        return productAppService.getProductsByBusinnesId(businessId);
    }

    public Boolean saveProduct(ProductRequest productRequest){
        Product product= modelMapper.map(productRequest, Product.class);
        return productAppService.saveProduct(product);
    }
}
