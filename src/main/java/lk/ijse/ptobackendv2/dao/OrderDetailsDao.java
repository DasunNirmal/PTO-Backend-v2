package lk.ijse.ptobackendv2.dao;

import lk.ijse.ptobackendv2.entity.impl.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDao  extends JpaRepository<OrderDetailsEntity, String> {
}
