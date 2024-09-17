package br.com.laserIot.palletManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.laserIot.palletManager.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Long>{

}
