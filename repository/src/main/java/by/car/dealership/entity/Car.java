package by.car.dealership.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
    private int weight;        // потом переделать на дабл или флоат

    @Column(name = "car_price")
    private int price;         // потом переделать в BigDecimal


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "wheel_id")
    private Wheel wheel;

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
}
