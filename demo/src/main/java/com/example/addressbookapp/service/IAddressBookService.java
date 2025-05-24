package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IAddressBookService {

    @Autowired
    private AddressBookRepository repository;

    public AddressBookData add(AddressBookDTO dto) {
        AddressBookData model = new AddressBookData();
        model.setName(dto.getName());
        model.setCity(dto.getCity());
        model.setPhoneNumber(dto.getPhoneNumber());
        return repository.save(model);
    }

    public List<AddressBookData> getAll() {
        return repository.findAll();
    }

    public AddressBookData getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new AddressBookException("Entry not found for ID " + id));
    }

    public AddressBookData update(int id, AddressBookDTO dto) {
        AddressBookData model = getById(id);
        model.setName(dto.getName());
        model.setCity(dto.getCity());
        model.setPhoneNumber(dto.getPhoneNumber());
        return repository.save(model);
    }

    public void delete(int id) {
        AddressBookData model = getById(id);
        repository.delete(model);
    }
}
