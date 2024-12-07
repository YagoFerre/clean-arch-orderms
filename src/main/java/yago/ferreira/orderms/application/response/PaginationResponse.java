package yago.ferreira.orderms.application.response;

public record PaginationResponse(
        Integer page,
        Integer pageSize,
        Long totalElements,
        Integer totalPages
) {
}
