package com.ksh.hexagonalarchitecture.application.port.in;

public interface UpdateItemUseCase {
    void updateItem(Long id, String name, int price, int stockQuantity);
}
