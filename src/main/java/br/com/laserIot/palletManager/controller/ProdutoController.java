package br.com.laserIot.palletManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.laserIot.palletManager.DTO.ProdutoDTO;
import br.com.laserIot.palletManager.service.ProdutoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listarTodos(){
        return produtoService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody ProdutoDTO produto){
        produtoService.criar(produto);
    }

    @PutMapping
    public ProdutoDTO alterar(@RequestBody ProdutoDTO produto){
        return produtoService.alterar(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
