package service.yourbookspring.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import service.yourbookspring.dto.OrderDTO;
import service.yourbookspring.entity.Order;
import service.yourbookspring.service.OrderService;

@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(value = "/order/create")
    public ResponseEntity<Order> create(@RequestBody OrderDTO orderDTO,
                                        @RequestHeader(name="Authorization") String token){
        return new ResponseEntity<>(orderService.create(orderDTO, token), HttpStatus.OK);
    }
}
