package com.ksh.hexagonalarchitecture.application;

import com.ksh.hexagonalarchitecture.application.port.in.FindItemUseCase;
import com.ksh.hexagonalarchitecture.application.port.in.SaveItemUseCase;
import com.ksh.hexagonalarchitecture.application.port.in.UpdateItemUseCase;
import com.ksh.hexagonalarchitecture.application.port.out.FindItemPort;
import com.ksh.hexagonalarchitecture.application.port.out.SaveItemPort;
import com.ksh.hexagonalarchitecture.application.port.out.UpdateItemPort;
import com.ksh.hexagonalarchitecture.domain.item.Item;
import com.ksh.hexagonalarchitecture.adapter.out.persistence.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService implements FindItemUseCase, SaveItemUseCase, UpdateItemUseCase {

    private final FindItemPort findItemPort;
    private final SaveItemPort saveItemPort;
    private final UpdateItemPort updateItemPort;
    private final ItemRepository itemRepository;

    @Transactional
    @Override
    public void saveItem(Item item) {
        saveItemPort.save(item);
    }

    @Transactional
    @Override
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item item = findItemPort.findOne(itemId);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }

    @Override
    public List<Item> findItems() {
        return findItemPort.findAll();
    }

    @Override
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
