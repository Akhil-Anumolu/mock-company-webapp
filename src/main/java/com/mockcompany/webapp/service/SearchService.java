package com.mockcompany.webapp.service;

import com.mockcompany.webapp.model.ProductItem;
import com.mockcompany.webapp.data.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class SearchService {

    private final ProductItemRepository productItemRepository;

    @Autowired
    public SearchService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    /**
     * RESTORED `search` method for compatibility with controllers.
     */
    public List<ProductItem> search(String query) {  // ✅ Restored
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptyList();
        }

        query = query.trim();
        boolean exactMatch = query.startsWith("\"") && query.endsWith("\"");
        query = query.replace("\"", "").trim();

        if (exactMatch) {
            return productItemRepository.findByNameIgnoreCaseOrDescriptionIgnoreCase(query, query);
        } else {
            return productItemRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
        }
    }
}
