package com.example.nodoapp.restcontroller;

import com.example.nodoapp.model.MuonSach;
import com.example.nodoapp.service.MuonSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/muon-sach")
@CrossOrigin(origins = "http://localhost:4200")
public class MuonSachRestController {
    @Autowired
    private MuonSachService muonSachService;

    @GetMapping("/all")
    public ResponseEntity<List<MuonSach>> getAllMuonSach() {
        List<MuonSach> muonSachList = muonSachService.getAllMuonSach();
        if (muonSachList.isEmpty()) {
            System.out.println("Không có bản ghi nào");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(muonSachList);
    }
    @PostMapping("/create")
    public ResponseEntity<MuonSach> createMuonSach(@RequestBody MuonSach muonSach) {
        MuonSach muonSach1 = muonSachService.create(muonSach);
        return ResponseEntity.ok(muonSach1);
    }
    @PutMapping("/update")
    public ResponseEntity<MuonSach> updateMuonSach(@RequestBody MuonSach muonSach) {
        MuonSach muonSach1 = muonSachService.update(muonSach);
        return ResponseEntity.ok(muonSach1);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MuonSach> deleteMuonSach(@PathVariable Integer id) {
        muonSachService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<MuonSach> findById(@PathVariable Integer id) {
        MuonSach muonSach = muonSachService.getById(id);
        if (muonSach == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(muonSach);
    }
}
