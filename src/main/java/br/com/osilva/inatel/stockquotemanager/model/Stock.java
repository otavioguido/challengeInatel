package br.com.osilva.inatel.stockquotemanager.model;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @ElementCollection
    @CollectionTable(
            name = "date_value",
            joinColumns = {@JoinColumn(name = "fk_stock", referencedColumnName = "id")},
            foreignKey = @ForeignKey(name = "quote_date", value = ConstraintMode.NO_CONSTRAINT))
    @MapKeyJoinColumn(name = "date")
    @Column(name = "value")
    private Map<LocalDate,Integer> quotes = new HashMap<>();
}
