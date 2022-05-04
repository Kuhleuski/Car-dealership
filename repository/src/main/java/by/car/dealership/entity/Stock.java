package by.car.dealership.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.asm.Advice;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToMany(mappedBy = "stock", fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.ALL)
//    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE},mappedBy = "stock")
    @JoinColumn(name = "car_id")
    private List<Car> carStock = new ArrayList<>();

    public List<Car> getCarStock() {
        return carStock;
    }

}