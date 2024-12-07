package yago.ferreira.orderms.infra.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yago.ferreira.orderms.application.response.PaginationResponse;
import yago.ferreira.orderms.application.services.OrderService;
import yago.ferreira.orderms.application.response.ApiResponse;
import yago.ferreira.orderms.application.response.OrderResponse;

@RestController
@RequestMapping("api/v1/orderms")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<ApiResponse<OrderResponse>> listOrders(
            @PathVariable Long customerId,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        Page<OrderResponse> pageResponse = orderService.findAllByCustomerId(customerId, PageRequest.of(page, pageSize));

        return ResponseEntity.ok(
                new ApiResponse<>(
                        pageResponse.getContent(),
                        new PaginationResponse(page, pageSize, pageResponse.getTotalElements(), pageResponse.getTotalPages())
                )
        );
    }
}
