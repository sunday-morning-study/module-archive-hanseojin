package com.ksh.hexagonalarchitecture.application.port.in;

import com.ksh.hexagonalarchitecture.domain.item.Item;

public interface SaveItemUseCase {
    void saveItem(Item item);
}
