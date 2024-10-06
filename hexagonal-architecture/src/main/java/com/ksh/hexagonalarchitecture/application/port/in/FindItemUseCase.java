package com.ksh.hexagonalarchitecture.application.port.in;

import com.ksh.hexagonalarchitecture.domain.item.Item;

import java.util.List;

public interface FindItemUseCase {
    List<Item> findItems();
    Item findOne(Long itemId);
}
