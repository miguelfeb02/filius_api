package aplication.service;

import aplication.repository.ProductAppRepository;
import domain.models.Product;
import domain.repository.ProductRepository;

import java.util.List;

public class ProductAppService implements ProductAppRepository {
    private final ProductRepository productRepository;

    public ProductAppService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByBusinnesId(String businessId) {
        return productRepository.getProductsByBusinnesId(businessId);
    }
    @Override
    public Boolean saveProduct(Product product) {
        Boolean existProduct= productRepository
                .existsByNameAndBusinessId(product.getName(), product.getBusinessId());
        if (existProduct) {
            return false;
        }
         productRepository.saveProduct(product);
        return true;

    }




}
