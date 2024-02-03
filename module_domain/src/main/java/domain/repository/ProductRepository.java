package domain.repository;

import domain.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getProductsByBusinnesId(String businessId);
    Boolean existsByNameAndBusinessId(String name,String businessId);
    Product saveProduct(Product product);
    void deleteProductById(String productId);
}
