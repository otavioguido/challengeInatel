package br.com.osilva.inatel.stockquotemanager.dao;

import br.com.osilva.inatel.stockquotemanager.exception.DataAccessException;
import br.com.osilva.inatel.stockquotemanager.model.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuotationDao {
    Stock createQuotation(Stock stock);

    Stock findQuotationById(String id) throws DataAccessException;

    Page<Stock> findAllQuotation(Pageable pageable);

    Stock updateQuotation(Stock stock);

    void deleteQuotation(Stock stock);
}
