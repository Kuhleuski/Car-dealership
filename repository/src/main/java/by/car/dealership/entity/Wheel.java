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
@Table(name = "wheel")
public class Wheel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wheel_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "size")
    private int size;     // потом переделать на шорт или дабл , В идеале в ENUM

    @Column(name = "price")
    private BigDecimal price;    // потом переделать в BigDecimal

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
        return id == wheel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
