package com.ksh.hexagonalarchitecture.controller;

import com.ksh.hexagonalarchitecture.domain.item.Book;
import com.ksh.hexagonalarchitecture.domain.item.Item;
import com.ksh.hexagonalarchitecture.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/items/new")
    public void create(BookForm form) {

        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> list() {
        List<Item> items = itemService.findItems();
        return ResponseEntity.ok().body(items);
    }

    @PostMapping("items/{itemId}/edit")
    public void updateItem2(@PathVariable Long itemId, @RequestBody Item form) {
        itemService.updateItem(itemId, form.getName(), form.getPrice(), form.getStockQuantity());
    }
}
