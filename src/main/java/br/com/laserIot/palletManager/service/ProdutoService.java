package br.com.laserIot.palletManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.laserIot.palletManager.DTO.ProdutoDTO;
import br.com.laserIot.palletManager.entity.ProdutoEntity;
import br.com.laserIot.palletManager.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar todos os produtos
    public List<ProdutoDTO> listarTodos() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoDTO::new).toList();
    }

    // Buscar produto por ID
    public ProdutoDTO buscarPorId(Long id) {
        Optional<ProdutoEntity> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            return new ProdutoDTO(produtoOptional.get());
        } else {
            throw new IllegalArgumentException("Produto não encontrado para o ID: " + id);
        }
    }

    // Criar um novo produto
    public void criar(ProdutoDTO produto) {
        if (produto.getName() == null || produto.getName().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio");
        }
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);
        produtoRepository.save(produtoEntity);
    }

    // Alterar um produto existente
    public ProdutoDTO alterar(ProdutoDTO produto) {
        Optional<ProdutoEntity> produtoOptional = produtoRepository.findById(produto.getId());
        if (produtoOptional.isPresent()) {
            ProdutoEntity produtoEntity = new ProdutoEntity(produto);
            return new ProdutoDTO(produtoRepository.save(produtoEntity));
        } else {
            throw new IllegalArgumentException("Produto não encontrado para o ID: " + produto.getId());
        }
    }

    // Excluir um produto
    public void excluir(Long id) {
        Optional<ProdutoEntity> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            produtoRepository.delete(produtoOptional.get());
        } else {
            throw new IllegalArgumentException("Produto não encontrado para o ID: " + id);
        }
    }
}

