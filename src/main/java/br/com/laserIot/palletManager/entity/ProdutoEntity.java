package br.com.laserIot.palletManager.entity;

import org.springframework.beans.BeanUtils;

import br.com.laserIot.palletManager.DTO.ProdutoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PM_PRODUTO", schema = "pallet_manager")
public class ProdutoEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer count;

    @Column(nullable = false)
    private Integer EPC;

    public ProdutoEntity(ProdutoDTO produto){
        BeanUtils.copyProperties(produto,this);
    }

    
}
