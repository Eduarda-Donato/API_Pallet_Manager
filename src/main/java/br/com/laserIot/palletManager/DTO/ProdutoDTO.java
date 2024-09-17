package br.com.laserIot.palletManager.DTO;

import org.springframework.beans.BeanUtils;

import br.com.laserIot.palletManager.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String name;
    private Integer count;
    private String EPC;

    public ProdutoDTO(ProdutoEntity produto){
        BeanUtils.copyProperties(produto,this);
    }

}
