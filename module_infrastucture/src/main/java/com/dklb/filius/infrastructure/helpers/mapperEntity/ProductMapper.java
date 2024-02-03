package com.dklb.filius.infrastructure.helpers.mapperEntity;

import com.dklb.filius.infrastructure.driven_adapter.database.product.ProductEntity;
import domain.models.Product;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    ModelMapper modelMapper=new ModelMapper();

   public Product toProduct(ProductEntity productEntity) {
        return modelMapper.map(productEntity,Product.class);
    }

   public ProductEntity toProductEntity(Product product) {
        return modelMapper.map(product,ProductEntity.class);
    }

     public List<Product> toProducts(List<ProductEntity> productsEntity) {
        return productsEntity.stream().map(
                productEntity -> modelMapper.map(productEntity,Product.class))
                .collect(Collectors.toList());
    }


}
