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
@Table(name = "wheel")
public class Wheel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wheel_id")
    private int id;

    @Column(name = "wheel_name")
    private String name;

    @Column(name = "wheel_model")
    private String model;

    @Column(name = "wheel_size")
    private int size;     // потом переделать на шорт или дабл , В идеале в ENUM

    @Column(name = "wheel_price")
    private int price;    // потом переделать в BigDecimal

    @OneToMany(mappedBy = "wheel", fetch = FetchType.LAZY)
    private Set<Car> cars = new HashSet<>();

    @Override
    public String toString() {
        return "Wheel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return id == wheel.id && size == wheel.size && price == wheel.price && Objects.equals(name, wheel.name) && Objects.equals(model, wheel.model) && Objects.equals(cars, wheel.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, size, price, cars);
    }

}
