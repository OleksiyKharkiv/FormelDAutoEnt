package com.example.formeldautoent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "production_processes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductionProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "production_status")
    private String productionStatus;

    @OneToMany(mappedBy = "productionProcess", cascade = CascadeType.ALL)
    private List<SupplyChain> supplyChains;

    @Override
    public String toString() {
        return "ProductionProcess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productionStatus='" + productionStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionProcess that = (ProductionProcess) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}