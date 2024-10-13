package lk.ijse.ptobackendv2.controller;

import lk.ijse.ptobackendv2.dto.impl.CombinedOrderDto;
import lk.ijse.ptobackendv2.dto.impl.ItemDto;
import lk.ijse.ptobackendv2.dto.impl.OrderDetailsDto;
import lk.ijse.ptobackendv2.dto.impl.OrderDto;
import lk.ijse.ptobackendv2.exception.DataPersistException;
import lk.ijse.ptobackendv2.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/api/v2/orderController")
public class OrderController {
    @Autowired
    private OrderService orderService;
    static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody CombinedOrderDto combinedOrderDto) {
        logger.info("POST Request Received");
        try {
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderID(combinedOrderDto.getOrderID());
            orderDto.setOrderDate(combinedOrderDto.getOrderDate());
            orderDto.setCustomerID(combinedOrderDto.getCustomerID());

            orderService.saveOrder(orderDto,combinedOrderDto);
            logger.info("Order Saved Successfully");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            logger.error("Data persistence error: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CombinedOrderDto> getAllItems() {
        logger.info("GET Request Received");
        return orderService.loadAllOrders();
    }
}
