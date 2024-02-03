package aplication.repository;

import domain.models.Product;

import java.util.List;

public interface ProductAppRepository {
    List<Product> getProductsByBusinnesId(String businessId);
    Boolean saveProduct(Product product);
}
