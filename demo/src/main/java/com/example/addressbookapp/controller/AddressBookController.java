package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<AddressBookData>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<AddressBookData> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted entry with ID " + id);
    }
}