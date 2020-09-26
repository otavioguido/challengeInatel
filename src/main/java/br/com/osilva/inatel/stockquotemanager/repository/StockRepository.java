package br.com.osilva.inatel.stockquotemanager.repository;

import br.com.osilva.inatel.stockquotemanager.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface StockRepository extends JpaRepository<Stock, String> {
}
