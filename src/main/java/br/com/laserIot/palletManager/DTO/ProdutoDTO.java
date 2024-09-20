package br.com.laserIot.palletManager.DTO;

import org.springframework.beans.BeanUtils;

import br.com.laserIot.palletManager.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
    
    private Long id;
    private String name;
    private LocalDate dataProduction;
    private LocalDate dataValidity;
    private double weight;
    private String supplier;
    private int countProductPack;

    public ProdutoDTO(ProdutoEntity produto){
        BeanUtils.copyProperties(produto, this);
    }
}
