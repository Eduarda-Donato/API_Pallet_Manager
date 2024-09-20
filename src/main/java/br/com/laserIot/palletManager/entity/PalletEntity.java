package br.com.laserIot.palletManager.entity;

import org.springframework.beans.BeanUtils;

import br.com.laserIot.palletManager.DTO.PalletDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="PM_PALLET", schema = "pallet_manager")
public class PalletEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false) // Relacionamento com ProdutoEntity
    @JoinColumn(name = "id_produto", referencedColumnName = "id") // FK apenas com idProduto
    private ProdutoEntity produto; 

    @ManyToOne
    @JoinColumn(name = "estoque_id", nullable = false)
    private EstoqueEntity estoque;

    @Column(nullable = false)
    private int countProductPack;

    @Column(nullable = false)
    private String EPC;

    @Column()
    private double weight;

    @Column()
    private String dimensions;
    
    public static PalletEntity fromDTO(PalletDTO palletDTO, ProdutoEntity produto, EstoqueEntity estoque) {
        PalletEntity palletEntity = new PalletEntity();
        palletEntity.setProduto(produto); // Associar o ProdutoEntity
        palletEntity.setEstoque(estoque); // Associar o EstoqueEntity
        palletEntity.setCountProductPack(palletDTO.getCountProductPack());
        palletEntity.setEPC(palletDTO.getEPC());
        palletEntity.setWeight(palletDTO.getWeight());
        palletEntity.setDimensions(palletDTO.getDimensions());
        return palletEntity;
    }
    
}
