package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AddressBookService {
    private final List<AddressBookData> addressList = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<AddressBookData> getAll() {
        return addressList;
    }

    public AddressBookData getById(int id) {
        return addressList.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public AddressBookData add(AddressBookDTO dto) {
        AddressBookData entry = new AddressBookData(idCounter.getAndIncrement(), dto.getName(), dto.getCity(), dto.getPhoneNumber());
        addressList.add(entry);
        return entry;
    }

    public AddressBookData update(int id, AddressBookDTO dto) {
        AddressBookData existing = getById(id);
        if (existing != null) {
            existing.setName(dto.getName());
            existing.setCity(dto.getCity());
            existing.setPhoneNumber(dto.getPhoneNumber());
        }
        return existing;
    }

    public void delete(int id) {
        addressList.removeIf(e -> e.getId() == id);
    }

	public Object create(AddressBookDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
