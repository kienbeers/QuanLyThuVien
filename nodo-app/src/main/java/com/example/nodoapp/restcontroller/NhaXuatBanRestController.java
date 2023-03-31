package com.example.nodoapp.restcontroller;

import com.example.nodoapp.model.NhaXuatBan;
import com.example.nodoapp.service.NhaXuatBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/nha-xuat-ban")
public class NhaXuatBanRestController {
    @Autowired
    public NhaXuatBanService nhaXuatBanService;

    @GetMapping("/all")
    public ResponseEntity<List<NhaXuatBan>> findAll() {
        List<NhaXuatBan> nhaXuatBanList = nhaXuatBanService.getAllNhaXuatBan();
        if (nhaXuatBanList.isEmpty()) {
            System.out.println("Không có bản ghi nào");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(nhaXuatBanList);
    }

    @PostMapping("/create")
    public ResponseEntity<NhaXuatBan> create(@RequestBody NhaXuatBan nhaXuatBan) {
        return ResponseEntity.ok(nhaXuatBanService.create(nhaXuatBan));
    }

    @PutMapping("/update")
    public ResponseEntity<NhaXuatBan> update(@RequestBody NhaXuatBan nhaXuatBan) {
        return ResponseEntity.ok(nhaXuatBanService.update(nhaXuatBan));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<NhaXuatBan> delete(@PathVariable Integer id) {
        nhaXuatBanService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<NhaXuatBan> findById(@PathVariable Integer id) {
        NhaXuatBan nhaXuatBan = nhaXuatBanService.getById(id);
        if (nhaXuatBan == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nhaXuatBan);
    }
}
