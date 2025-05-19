package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressService;

    @GetMapping("/")
    public List<AddressBookData> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/get/{id}")
    public AddressBookData getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PostMapping("/create")
    public AddressBookData create(@RequestBody AddressBookDTO dto) {
        return addressService.add(dto);
    }

    @PutMapping("/update")
    public AddressBookData update(@RequestParam int id, @RequestBody AddressBookDTO dto) {
        return addressService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
