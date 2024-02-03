package com.dklb.filius.infrastructure.driven_adapter.database.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoCrudRepository extends JpaRepository<ProductEntity, String> {
      List<ProductEntity> findByBusinessId(String businessId);
      Boolean existsByNameAndBusinessId(String name,String businessId);
      ProductEntity save(ProductEntity productEntity);
      void deleteByProductId(String productId);

}
