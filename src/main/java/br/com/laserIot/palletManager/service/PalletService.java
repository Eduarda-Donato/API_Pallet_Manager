package br.com.laserIot.palletManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.laserIot.palletManager.DTO.PalletDTO;
import br.com.laserIot.palletManager.entity.PalletEntity;
import br.com.laserIot.palletManager.entity.ProdutoEntity;
import br.com.laserIot.palletManager.entity.EstoqueEntity;
import br.com.laserIot.palletManager.repository.PalletRepository;
import br.com.laserIot.palletManager.repository.ProdutoRepository;
import br.com.laserIot.palletManager.repository.EstoqueRepository;

@Service
public class PalletService {

    @Autowired
    private PalletRepository palletRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    // Lista todos os pallets
    public List<PalletDTO> listarTodos() {
        List<PalletEntity> pallets = palletRepository.findAll();
        return pallets.stream().map(PalletDTO::new).toList();
    }

    // Busca um pallet por ID
    public PalletDTO buscarPorId(Long id) {
        PalletEntity pallet = palletRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Pallet não encontrado: " + id));
        return new PalletDTO(pallet);
    }

    // Cria um novo pallet
    public void criar(PalletDTO palletDTO) {
        // Busca o ProdutoEntity pelo produtoId
        ProdutoEntity produto = produtoRepository.findById(palletDTO.getProdutoId())
            .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + palletDTO.getProdutoId()));

        // Verifica se o EPC é válido
        if (palletDTO.getEPC() == null || palletDTO.getEPC().isEmpty()) {
            throw new IllegalArgumentException("EPC não pode ser nulo ou vazio");
        }

        // Busca o EstoqueEntity pelo estoqueId (se necessário)
        EstoqueEntity estoque = estoqueRepository.findById(palletDTO.getEstoqueId())
            .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado: " + palletDTO.getEstoqueId()));

        // Cria o PalletEntity a partir do PalletDTO e associa Produto e Estoque
        PalletEntity palletEntity = PalletEntity.fromDTO(palletDTO, produto, estoque);

        // Salva o PalletEntity no banco de dados
        palletRepository.save(palletEntity);
    }

    // Altera um pallet existente
    public PalletDTO alterar(PalletDTO palletDTO) {
        // Busca o ProdutoEntity pelo produtoId
        ProdutoEntity produto = produtoRepository.findById(palletDTO.getProdutoId())
            .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + palletDTO.getProdutoId()));

        // Busca o EstoqueEntity pelo estoqueId
        EstoqueEntity estoque = estoqueRepository.findById(palletDTO.getEstoqueId())
            .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado: " + palletDTO.getEstoqueId()));

        // Cria o PalletEntity a partir do PalletDTO e associa Produto e Estoque
        PalletEntity palletEntity = PalletEntity.fromDTO(palletDTO, produto, estoque);

        // Salva o pallet alterado no banco de dados e retorna o DTO atualizado
        PalletEntity palletAtualizado = palletRepository.save(palletEntity);
        return new PalletDTO(palletAtualizado);
    }

    // Exclui um pallet
    public void excluir(Long id) {
        PalletEntity pallet = palletRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Pallet não encontrado: " + id));
        palletRepository.delete(pallet);
    }
}
