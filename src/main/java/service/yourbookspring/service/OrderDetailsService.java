package service.yourbookspring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.yourbookspring.dto.OrderDetailsDTO;
import service.yourbookspring.entity.OrderDetails;
import service.yourbookspring.repository.OrderDetailsRepository;

@Service
@AllArgsConstructor
public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetails create(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = OrderDetails
                .builder()
                .books(orderDetailsDTO.getBooks())
                .order(orderDetailsDTO.getOrder())
                .build();
        return orderDetailsRepository.save(orderDetails);
    }
}
