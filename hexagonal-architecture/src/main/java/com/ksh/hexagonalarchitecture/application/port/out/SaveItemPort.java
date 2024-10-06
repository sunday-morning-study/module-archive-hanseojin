package com.ksh.hexagonalarchitecture.application.port.out;

import com.ksh.hexagonalarchitecture.domain.item.Item;

public interface SaveItemPort {
    void save(Item item);
}
