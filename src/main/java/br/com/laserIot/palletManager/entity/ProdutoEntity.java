package br.com.laserIot.palletManager.entity;

import java.time.LocalDate;

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

    @Column(nullable = false)
    private LocalDate dataProduction;

    @Column()
    private LocalDate dataValidity;

    @Column()
    private double weight;

    @Column(nullable = false)
    private String supplier;

    @Column(nullable = false)
    private int countProductPack;
    
    public ProdutoEntity(ProdutoDTO pallet){
        BeanUtils.copyProperties(pallet,this);
    } 
}
