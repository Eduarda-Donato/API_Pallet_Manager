package br.com.laserIot.palletManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.laserIot.palletManager.DTO.ProdutoDTO;
import br.com.laserIot.palletManager.entity.ProdutoEntity;
import br.com.laserIot.palletManager.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarTodos(){
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoDTO::new).toList();
    }

    public ProdutoDTO buscarPorId (Long id){
        ProdutoEntity produto = produtoRepository.findById(id).get();
        return new ProdutoDTO(produto);
    }

    public void criar(ProdutoDTO produto){
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);
        produtoRepository.save(produtoEntity);
    }

    public ProdutoDTO alterar(ProdutoDTO produto){
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);
        return new ProdutoDTO(produtoRepository.save(produtoEntity));
    }

    public void excluir(Long id){
        ProdutoEntity produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
}
