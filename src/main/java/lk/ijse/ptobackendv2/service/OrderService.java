package lk.ijse.ptobackendv2.service;

import lk.ijse.ptobackendv2.dto.impl.CombinedOrderDto;
import lk.ijse.ptobackendv2.dto.impl.OrderDto;

public interface OrderService {
    void saveOrder(OrderDto orderDto, CombinedOrderDto combinedOrderDto);
}
