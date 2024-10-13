package lk.ijse.ptobackendv2.entity.impl;

import jakarta.persistence.*;
import lk.ijse.ptobackendv2.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Orders")
public class OrderEntity implements SuperEntity {
    @Id
    private String orderID;
    private String orderDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customerID",nullable = true)
    private CustomerEntity customer;
    @OneToMany(mappedBy = "order")
    private List<OrderDetailsEntity> orderDetails;
}
