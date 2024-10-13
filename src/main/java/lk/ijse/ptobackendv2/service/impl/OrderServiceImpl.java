package lk.ijse.ptobackendv2.service.impl;

import lk.ijse.ptobackendv2.dao.OrderDao;

import lk.ijse.ptobackendv2.dao.OrderDetailsDao;
import lk.ijse.ptobackendv2.dto.impl.CombinedOrderDto;
import lk.ijse.ptobackendv2.dto.impl.OrderDetailsDto;
import lk.ijse.ptobackendv2.dto.impl.OrderDto;
import lk.ijse.ptobackendv2.entity.impl.OrderEntity;
import lk.ijse.ptobackendv2.exception.DataPersistException;
import lk.ijse.ptobackendv2.service.OrderService;
import lk.ijse.ptobackendv2.uill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDto orderDto, CombinedOrderDto combinedOrderDto) {
        OrderEntity orderEntity = orderDao.save(mapping.toOrderEntity(orderDto));
        if (orderEntity == null) {
            throw new DataPersistException("Order Not Saved");
        } else {
            OrderDetailsDto dto = new OrderDetailsDto();
            dto.setDetailsID(orderDto.getOrderID());
            dto.setOrderID(orderDto);
            dto.setItemID(combinedOrderDto.getItemID());
            dto.setItemName(combinedOrderDto.getItemName());
            dto.setItemPrice(combinedOrderDto.getItemPrice());
            dto.setItemQty(combinedOrderDto.getItemQty());
            dto.setOrderQty(combinedOrderDto.getOrderQty());
            dto.setOrderDate(combinedOrderDto.getOrderDate());
            dto.setCustomerID(combinedOrderDto.getCustomerID());
            dto.setTotalPrice(combinedOrderDto.getTotalPrice());
            saveOrderDetails(dto);
        }
    }

    private void saveOrderDetails(OrderDetailsDto orderDetailsDto) {
        orderDetailsDao.save(mapping.toOrderDetailsEntity(orderDetailsDto));
    }
}
