package br.com.laserIot.palletManager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PM_ESTOQUE", schema = "pallet_manager")
public class EstoqueEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private int capacidadeTotal;

    @OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PalletEntity> pallets;

    // Método para adicionar um pallet ao estoque
    public void adicionarPallet(PalletEntity pallet) {
        pallets.add(pallet);
        pallet.setEstoque(this); // Relaciona o pallet com o estoque
    }

    // Método para remover um pallet do estoque
    public void removerPallet(PalletEntity pallet) {
        pallets.remove(pallet);
        pallet.setEstoque(null); // Remove a associação entre pallet e estoque
    }
}

