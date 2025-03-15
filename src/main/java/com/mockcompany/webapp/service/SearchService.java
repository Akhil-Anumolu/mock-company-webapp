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

    /**
     * Constructor-based dependency injection.
     *
     * @param productItemRepository Injected repository for accessing product data.
     */
    @Autowired
    public SearchService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    /**
     * **✅ Restored Correct Functionality**
     * Searches for products by name or description.
     *
     * @param query The search term.
     * @return List of matching products or an empty list if none found.
     */
    public List<ProductItem> search(String query) {
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptyList();
        }

        query = query.trim();
        boolean exactMatch = query.startsWith("\"") && query.endsWith("\"");

        query = query.replace("\"", "").trim();

        List<ProductItem> results;
        if (exactMatch) {
            results = productItemRepository.findByNameIgnoreCaseOrDescriptionIgnoreCase(query, query);
        } else {
            results = productItemRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
        }

        return results.isEmpty() ? Collections.emptyList() : results;
    }
}
