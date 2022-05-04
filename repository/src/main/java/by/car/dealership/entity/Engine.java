package by.car.dealership.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "engine")

public class Engine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engine_id")
    private int id;

    @Column(name = "engine_name")
    private String name;

    @Column(name = "engine_model")
    private String model;

    @Column(name = "engine_fuel_tupe")
    private String fuelType;

    @Column(name = "engine_displacement")
    private int displacement;

    @Column(name = "engine_price")
    private BigDecimal price;

    @OneToMany(mappedBy = "engine", fetch = FetchType.LAZY)
    private Set<Car> cars = new HashSet<>();


    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", displacement=" + displacement +
                ", price=" + price +
                '}';
    }


}
