package com.dklb.filius.infrastructure.driven_adapter.database.product;

import domain.models.Product;
import domain.repository.ProductRepository;
import com.dklb.filius.infrastructure.helpers.mapperEntity.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ProductImplement implements ProductRepository {


    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    private final ProductMapper productMapper=new ProductMapper();



    @Override
    public  List<Product> getProductsByBusinnesId(String businessId) {
        return productMapper.toProducts(
                productoCrudRepository.findByBusinessId(businessId));
    }
    @Override
    public Boolean existsByNameAndBusinessId(String name,String businessId) {
        return productoCrudRepository.existsByNameAndBusinessId(name,businessId);
    }

    @Override
    public Product saveProduct(Product product) {
        return productMapper.toProduct(
                productoCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public void deleteProductById(String productId) {
        productoCrudRepository.deleteByProductId(productId);
    }


}
