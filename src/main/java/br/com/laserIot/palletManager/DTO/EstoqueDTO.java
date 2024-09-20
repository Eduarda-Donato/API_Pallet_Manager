package br.com.laserIot.palletManager.DTO;

import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.laserIot.palletManager.entity.EstoqueEntity;
import br.com.laserIot.palletManager.entity.PalletEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class EstoqueDTO {
    private Long id;
    private String localizacao;
    private int capacidadeTotal;
    private List<PalletEntity> pallets;

    // Método para adicionar um pallet ao estoque
    public EstoqueDTO(EstoqueEntity estoque) {
        BeanUtils.copyProperties(estoque,this);
    }

}
