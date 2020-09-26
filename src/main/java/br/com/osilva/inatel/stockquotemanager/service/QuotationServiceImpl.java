package br.com.osilva.inatel.stockquotemanager.service;

import br.com.osilva.inatel.stockquotemanager.dao.QuotationDao;
import br.com.osilva.inatel.stockquotemanager.exception.DataAccessException;
import br.com.osilva.inatel.stockquotemanager.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private QuotationDao quotationDao;

    @Override
    public Stock saveQuotation(Stock stock) {
        return quotationDao.createQuotation(stock);
    }

    @Override
    public Stock findQuotationById(String id) throws DataAccessException {
        return quotationDao.findQuotationById(id);
    }

    @Override
    public Page<Stock> findAllQuotation(Pageable pageable) {
        return quotationDao.findAllQuotation(pageable);
    }

    @Override
    public Stock updateQuotation(Stock stock) {
        return quotationDao.updateQuotation(stock);
    }

    @Override
    public void deleteQuotation(Stock stock) {
        quotationDao.deleteQuotation(stock);
    }
}
