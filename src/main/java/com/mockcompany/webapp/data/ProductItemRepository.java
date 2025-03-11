package com.mockcompany.webapp.data;

import com.mockcompany.webapp.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    // ✅ Method to find exact name or description match (ignoring case)
    List<ProductItem> findByNameIgnoreCaseOrDescriptionIgnoreCase(String name, String description);

    // ✅ Method to find partial match (ignoring case)
    List<ProductItem> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
}
