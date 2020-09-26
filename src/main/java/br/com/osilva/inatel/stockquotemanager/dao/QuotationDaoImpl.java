package br.com.osilva.inatel.stockquotemanager.dao;

import br.com.osilva.inatel.stockquotemanager.exception.DataAccessException;
import br.com.osilva.inatel.stockquotemanager.model.Stock;
import br.com.osilva.inatel.stockquotemanager.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class QuotationDaoImpl implements QuotationDao {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock createQuotation(Stock stock) {
        return stockRepository.saveAndFlush(stock);
    }

    @Override
    public Stock findQuotationById(String id) throws DataAccessException {
        return stockRepository
                .findById(id)
                .orElseThrow(() -> new DataAccessException(
                        String.format("Did not find stock by id %s", id)));
    }

    @Override
    public Page<Stock> findAllQuotation(Pageable pageable) {
        return stockRepository.findAll(pageable);
    }

    @Override
    public Stock updateQuotation(Stock stock) {
        return stockRepository.saveAndFlush(stock);
    }

    @Override
    public void deleteQuotation(Stock stock) {
        stockRepository.delete(stock);
    }
}
