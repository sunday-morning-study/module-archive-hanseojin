package com.ksh.hexagonalarchitecture.adapter.out.persistence;

import com.ksh.hexagonalarchitecture.application.port.in.FindItemUseCase;
import com.ksh.hexagonalarchitecture.application.port.in.SaveItemUseCase;
import com.ksh.hexagonalarchitecture.application.port.in.UpdateItemUseCase;
import com.ksh.hexagonalarchitecture.application.port.out.FindItemPort;
import com.ksh.hexagonalarchitecture.application.port.out.SaveItemPort;
import com.ksh.hexagonalarchitecture.application.port.out.UpdateItemPort;
import com.ksh.hexagonalarchitecture.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemPersistenceAdapter implements FindItemPort, SaveItemPort, UpdateItemPort {
    private final ItemRepository itemRepository;

    @Override
    public Item findOne(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }
}
