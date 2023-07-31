package com.example.formeldautoent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "supply_chains")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplyChain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String supplier;

    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private Component component;

    @ManyToOne
    @JoinColumn(name = "production_process_id", nullable = false)
    private ProductionProcess productionProcess;

    private int quantity;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Override
    public String toString() {
        return "SupplyChain{" +
                "id=" + id +
                ", supplier='" + supplier + '\'' +
                ", component=" + component +
                ", productionProcess=" + productionProcess +
                ", quantity=" + quantity +
                ", deliveryDate=" + deliveryDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplyChain that = (SupplyChain) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}