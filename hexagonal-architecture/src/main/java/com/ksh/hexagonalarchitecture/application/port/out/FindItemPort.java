package com.ksh.hexagonalarchitecture.application.port.out;

import com.ksh.hexagonalarchitecture.domain.item.Item;

import java.util.List;

public interface FindItemPort {

    Item findOne(Long id);
    List<Item> findAll();
}
