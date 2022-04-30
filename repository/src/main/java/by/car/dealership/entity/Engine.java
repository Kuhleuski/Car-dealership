package by.car.dealership.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
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
    private String fuelType;    //потом переделать в ENUM

    @Column(name = "engine_displacement")
    private int displacement;   // потом переделать на дабл или шорт

    @Column(name = "engine_price")
    private int price;         // потом переделать в BigDecimal

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return id == engine.id && displacement == engine.displacement && price == engine.price && Objects.equals(name, engine.name) && Objects.equals(model, engine.model) && Objects.equals(fuelType, engine.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, fuelType, displacement, price);
    }
}
