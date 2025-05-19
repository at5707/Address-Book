package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AddressBookService implements IAddressBookService {
    private final List<AddressBookData> addressList = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public List<AddressBookData> getAll() {
        return addressList;
    }

    @Override
    public AddressBookData getById(int id) {
        return addressList.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public AddressBookData add(AddressBookDTO dto) {
        AddressBookData entry = new AddressBookData(idCounter.getAndIncrement(), dto.getName(), dto.getCity(), dto.getPhoneNumber());
        addressList.add(entry);
        return entry;
    }

    @Override
    public AddressBookData update(int id, AddressBookDTO dto) {
        AddressBookData existing = getById(id);
        if (existing != null) {
            existing.setName(dto.getName());
            existing.setCity(dto.getCity());
            existing.setPhoneNumber(dto.getPhoneNumber());
        }
        return existing;
    }

    @Override
    public void delete(int id) {
        addressList.removeIf(e -> e.getId() == id);
    }
}
