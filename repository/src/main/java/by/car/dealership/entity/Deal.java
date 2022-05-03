package by.car.dealership.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@Builder
@Entity
@Table(name = "deal")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(updatable = false)
    private Car car;

    @OneToOne
    @JoinColumn(updatable = false)
    private Customer customer;

    @Column(name = "date", updatable = false)
    private String date;

    public Deal() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = formater.format(new Date());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return id == deal.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", date='" + date + '\'' +
                '}';
    }
}
