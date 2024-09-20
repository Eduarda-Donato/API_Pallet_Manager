package br.com.laserIot.palletManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.laserIot.palletManager.entity.EstoqueEntity;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity,Long>{
    
}
