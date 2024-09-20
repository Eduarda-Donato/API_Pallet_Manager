package br.com.laserIot.palletManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.laserIot.palletManager.DTO.PalletDTO;
import br.com.laserIot.palletManager.service.PalletService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/pallet")
public class PalletController {
    @Autowired
    PalletService palletService;

    @GetMapping
    public List<PalletDTO> listarTodos(){
        return palletService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody PalletDTO pallet){
        palletService.criar(pallet);
    }

    @PutMapping
    public PalletDTO alterar(@RequestBody PalletDTO pallet){
        return palletService.alterar(pallet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        palletService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
