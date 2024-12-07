package yago.ferreira.orderms.application.response;

import java.util.List;

public record ApiResponse<T>(List<T> data, PaginationResponse pagination) {
}
