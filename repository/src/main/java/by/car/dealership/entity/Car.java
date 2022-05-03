package by.car.dealership.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_name")
    private String name;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_body_type")
    private String bodyType;

    @Column(name = "car_weight")
    private int weight;

    @Column(name = "car_price")
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "wheel_id")
    private Wheel wheel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", engine=" + engine +
                ", wheel=" + wheel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
