package lk.ijse.ptobackendv2.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CombinedOrderDto {
    private String orderID;
    private String orderDate;
    private String customerID;
    private String itemID;
    private String itemName;
    private double itemPrice;
    private int itemQty;
    private int orderQty;
    private double totalPrice;
}
