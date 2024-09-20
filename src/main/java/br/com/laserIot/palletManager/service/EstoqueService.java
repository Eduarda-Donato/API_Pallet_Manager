package br.com.laserIot.palletManager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.laserIot.palletManager.DTO.EstoqueDTO;
import br.com.laserIot.palletManager.entity.EstoqueEntity;
import br.com.laserIot.palletManager.repository.EstoqueRepository;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    // Listar todos os estoques
    public List<EstoqueDTO> listarTodos() {
        List<EstoqueEntity> estoques = estoqueRepository.findAll();
        return estoques.stream().map(EstoqueDTO::new).collect(Collectors.toList());
    }

    // Buscar um estoque por ID
    public EstoqueDTO buscarPorId(Long id) {
        EstoqueEntity estoque = estoqueRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado: " + id));
        return new EstoqueDTO(estoque);
    }

    // Criar um novo estoque
    public void criar(EstoqueDTO estoqueDTO) {
        EstoqueEntity estoqueEntity = new EstoqueEntity();
        estoqueEntity.setLocalizacao(estoqueDTO.getLocalizacao());
        estoqueEntity.setCapacidadeTotal(estoqueDTO.getCapacidadeTotal());
        estoqueRepository.save(estoqueEntity);
    }

    // Alterar um estoque existente
    public EstoqueDTO alterar(EstoqueDTO estoqueDTO) {
        EstoqueEntity estoqueEntity = estoqueRepository.findById(estoqueDTO.getId())
            .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado: " + estoqueDTO.getId()));
        
        estoqueEntity.setLocalizacao(estoqueDTO.getLocalizacao());
        estoqueEntity.setCapacidadeTotal(estoqueDTO.getCapacidadeTotal());

        // Atualizar o estoque no banco de dados e retornar o DTO atualizado
        estoqueEntity = estoqueRepository.save(estoqueEntity);
        return new EstoqueDTO(estoqueEntity);
    }

    // Excluir um estoque
    public void excluir(Long id) {
        EstoqueEntity estoque = estoqueRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado: " + id));
        estoqueRepository.delete(estoque);
    }
}
