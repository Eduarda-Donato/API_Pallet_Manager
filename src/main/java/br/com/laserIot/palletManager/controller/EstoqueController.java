package br.com.laserIot.palletManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.laserIot.palletManager.DTO.EstoqueDTO;
import br.com.laserIot.palletManager.service.EstoqueService;


@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<EstoqueDTO> listarTodos() {
        return estoqueService.listarTodos();
    }

    @GetMapping("/{id}")
    public EstoqueDTO buscarPorId(@PathVariable Long id) {
        return estoqueService.buscarPorId(id);
    }

    @PostMapping
    public void criar(@RequestBody EstoqueDTO estoqueDTO) {
        estoqueService.criar(estoqueDTO);
    }

    @PutMapping("/{id}")
    public EstoqueDTO alterar(@PathVariable Long id, @RequestBody EstoqueDTO estoqueDTO) {
        estoqueDTO.setId(id);  // Certifique-se de que o ID está correto
        return estoqueService.alterar(estoqueDTO);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        estoqueService.excluir(id);
    }
}

