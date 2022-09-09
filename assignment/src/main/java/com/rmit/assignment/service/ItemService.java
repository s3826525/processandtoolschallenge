package com.rmit.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmit.assignment.dao.ItemDao;
import com.rmit.assignment.exceptions.ServiceExceptionHandler;
import com.rmit.assignment.models.Item;
import com.rmit.assignment.repository.ItemRepository;

@Service
public class ItemService {

    ItemRepository itemRepository;

    // method to get item
    public Optional<Item> getItem(ItemDao itemDao) {
        return this.itemRepository.findById(itemDao.getId());
    }

    // method to get items in a list
    public List<Item> getItemList() {
        return this.itemRepository.findAll();
    }

    // method to update item
    public Item updateItem(ItemDao itemUpdateDao) {
        if (itemRepository.findById(itemUpdateDao.getId()).isPresent()) {
            Item existingItem = itemRepository.findById(itemUpdateDao.getId()).get();
            // checking if entered details to update are null or present
            if (itemUpdateDao.getDesc() != null) {
                existingItem.setDesc(itemUpdateDao.getDesc());
            }
            if (itemUpdateDao.getImagePath() != null) {
                existingItem.setImagePath(itemUpdateDao.getImagePath());
            }
            if (itemUpdateDao.getTitle() != null) {
                existingItem.setTitle(itemUpdateDao.getTitle());
            }
            if (itemUpdateDao.getPrice() != null) {
                existingItem.setPrice(itemUpdateDao.getPrice());
            }
            Item updatedItem = itemRepository.save(existingItem);
            return updatedItem;
        } else {
            // add throw error statement
            throw new ServiceExceptionHandler("item not found");
        }
    }

    // method to delete item
    public Item deleteItem(ItemDao itemDao) {
        if (itemRepository.findById(itemDao.getId()).isPresent()) {
            Item existingItem = itemRepository.findById(itemDao.getId()).get();
            itemRepository.deleteById(existingItem.getId());
            return existingItem;
        } else {
            // add throw error statement
            throw new ServiceExceptionHandler("Item not found");
        }
    }

}
