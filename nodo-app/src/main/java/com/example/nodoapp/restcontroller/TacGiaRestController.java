package com.example.nodoapp.restcontroller;

import com.example.nodoapp.model.TacGia;
import com.example.nodoapp.service.TacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tac-gia")
public class TacGiaRestController {
    @Autowired
    public TacGiaService tacGiaService;

    @GetMapping("/all")
    public ResponseEntity<List<TacGia>> findAll() {
        List<TacGia> tacGiaList = tacGiaService.getAllTacGia();
        if (tacGiaList.isEmpty()) {
            System.out.println("Không có bản ghi nào");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tacGiaList);
    }

    @PostMapping("/create")
    public ResponseEntity<TacGia> create(@RequestBody TacGia tacGia) {
        return ResponseEntity.ok(tacGiaService.create(tacGia));
    }

    @PutMapping("/update")
    public ResponseEntity<TacGia> update(@RequestBody TacGia tacGia) {
        return ResponseEntity.ok(tacGiaService.update(tacGia));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TacGia> delete(@PathVariable Integer id) {
        tacGiaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TacGia> findById(@PathVariable Integer id) {
        TacGia tacGia = tacGiaService.getById(id);
        if (tacGia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tacGia);
    }
}
