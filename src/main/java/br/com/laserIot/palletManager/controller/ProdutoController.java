package br.com.laserIot.palletManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.laserIot.palletManager.DTO.ProdutoDTO;
import br.com.laserIot.palletManager.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    // Listar todos os produtos
    @GetMapping
    public List<ProdutoDTO> listarTodos() {
        return produtoService.listarTodos();
    }

    // Buscar um produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Long id) {
        ProdutoDTO produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    // Inserir um novo produto
    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody ProdutoDTO produto) {
        produtoService.criar(produto);
        return ResponseEntity.ok().build(); // Retorna 200 (OK)
    }

    // Alterar um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> alterar(@PathVariable Long id, @RequestBody ProdutoDTO produto) {
        produto.setId(id); // Certifica-se de que o ID é o mesmo da URL
        ProdutoDTO produtoAlterado = produtoService.alterar(produto);
        return ResponseEntity.ok(produtoAlterado);
    }

    // Excluir um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
