package br.com.osilva.inatel.stockquotemanager.service;

import br.com.osilva.inatel.stockquotemanager.exception.DataAccessException;
import br.com.osilva.inatel.stockquotemanager.model.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuotationService {
    Stock saveQuotation(Stock stock);

    Stock findQuotationById(String id) throws DataAccessException;

    Page<Stock> findAllQuotation(Pageable pageable);

    Stock updateQuotation(Stock stock);

    void deleteQuotation(Stock stock);
}
