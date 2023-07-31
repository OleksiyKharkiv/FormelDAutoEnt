package com.example.formeldautoent.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "experimental_cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentalCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_model_id", nullable = false)
    private CarModel carModel;

    @Column(name = "test_parameters")
    private String testParameters;

    @Column(name = "test_results")
    private String testResults;

    @Override
    public String toString() {
        return "ExperimentalCar{" +
                "id=" + id +
                ", carModel=" + carModel +
                ", testParameters='" + testParameters + '\'' +
                ", testResults='" + testResults + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperimentalCar that = (ExperimentalCar) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}