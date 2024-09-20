package br.com.laserIot.palletManager.DTO;

import org.springframework.beans.BeanUtils;

import br.com.laserIot.palletManager.entity.PalletEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PalletDTO {
    private Long id;
    private Long produtoId;
    private Long estoqueId;
    private int countProductPack;
    private String EPC;
    private double weight;
    private String dimensions;

    public PalletDTO(PalletEntity pallet) {
        BeanUtils.copyProperties(pallet, this);

        
        this.produtoId = pallet.getProduto() != null ? pallet.getProduto().getId() : null;
        this.estoqueId = pallet.getEstoque() != null ? pallet.getEstoque().getId() : null;
    }

}
