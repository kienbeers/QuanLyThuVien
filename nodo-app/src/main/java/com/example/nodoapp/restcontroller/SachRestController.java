package com.example.nodoapp.restcontroller;

import com.example.nodoapp.model.Sach;
import com.example.nodoapp.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sach")
@CrossOrigin(origins = "http://localhost:4200")
public class SachRestController {
    @Autowired
    private SachService sachService;

    @GetMapping("/all")
    public ResponseEntity<List<Sach>> getAllSach() {
        List<Sach> sachList = sachService.getAllSach();
        if (sachList.isEmpty()) {
            System.out.println("Không có bản ghi nào");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sachList);
    }

    @PostMapping("/create")
    public ResponseEntity<Sach> createSach(@RequestBody Sach sach) {
        Sach sach1 = sachService.create(sach);
        return ResponseEntity.ok(sach1);
    }

    @PutMapping("/update")
    public ResponseEntity<Sach> updateSach(@RequestBody Sach sach) {
        Sach sach1 = sachService.update(sach);
        return ResponseEntity.ok(sach1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sach> deleteSach(@PathVariable Integer id) {
        sachService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Sach> findById(@PathVariable Integer id) {
        Sach sach = sachService.getById(id);
        if (sach == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sach);
    }
}
