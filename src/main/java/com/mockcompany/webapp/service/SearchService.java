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
    @Autowired  // ✅ Explicit annotation for better clarity
    public SearchService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    /**
     * **🔴 INTENTIONAL TEST FAILURE 🔴**
     * Forces the test to fail by always returning an empty list.
     *
     * @param query The search term.
     * @return Always returns an empty list.
     */
    public List<ProductItem> searchProducts(String query) {
        System.out.println("DEBUG: SearchService is running with query: " + query); // ✅ NEW LINE

        return Collections.emptyList(); // ❌ This will break tests on purpose
    }
}
//changes detect
// Triggering Git to detect changes// Added a new line to force Git detection

