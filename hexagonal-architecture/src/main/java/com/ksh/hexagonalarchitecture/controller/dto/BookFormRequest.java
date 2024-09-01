package com.ksh.hexagonalarchitecture.controller.dto;

public record BookFormRequest(
        Long id,
        String name,
        int price,
        int stockQuantity,
        String author,
        String isbn
) {
}
