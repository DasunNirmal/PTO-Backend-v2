package lk.ijse.ptobackendv2.uill;

import lk.ijse.ptobackendv2.dao.ItemDao;
import lk.ijse.ptobackendv2.dto.impl.*;
import lk.ijse.ptobackendv2.entity.impl.CustomerEntity;
import lk.ijse.ptobackendv2.entity.impl.ItemEntity;
import lk.ijse.ptobackendv2.entity.impl.OrderDetailsEntity;
import lk.ijse.ptobackendv2.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemDao itemDao;

    /*customer mapping*/
    public CustomerEntity toCustomerEntity(CustomerDto customerDto) {
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
    public CustomerDto toCustomerDto(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    public List<CustomerDto> toCustomerDtoList(List<CustomerEntity> customerEntityList) {
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDto>>() {}.getType());
    }
    /*item mapping*/
    public ItemEntity toItemEntity(ItemDto itemDto) {
        return modelMapper.map(itemDto, ItemEntity.class);
    }
    public ItemDto toItemDto(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDto.class);
    }

    public List<ItemDto> toItemDtoList(List<ItemEntity> itemEntityList) {
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDto>>() {}.getType());
    }
    /*order mapping*/
    public OrderEntity toOrderEntity(OrderDto orderDto) {
        return modelMapper.map(orderDto, OrderEntity.class);
    }
    public OrderDto toOrderDto(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDto.class);
    }

    public List<OrderDto> toOrderDtoList(List<OrderEntity> orderEntityList) {
        return modelMapper.map(orderEntityList, new TypeToken<List<OrderDto>>() {}.getType());
    }

    /*order details mapping*/
    public OrderDetailsEntity toOrderDetailsEntity(OrderDetailsDto orderDetailsDto) {
        return modelMapper.map(orderDetailsDto, OrderDetailsEntity.class);
    }
    public OrderDetailsDto toOrderDetailsDto(OrderDetailsEntity orderDetailsEntity) {
        return modelMapper.map(orderDetailsEntity, OrderDetailsDto.class);
    }

    public List<OrderDetailsDto> toOrderDetailsDtoList(List<OrderDetailsEntity> orderDetailsEntities) {
        return modelMapper.map(orderDetailsEntities, new TypeToken<List<OrderDetailsDto>>() {}.getType());
    }

    public List<CombinedOrderDto> toOrderDetailsDtoLists(List<OrderDetailsEntity> orderDetailsEntities) {
        return modelMapper.map(orderDetailsEntities, new TypeToken<List<CombinedOrderDto>>() {}.getType());
    }
}
