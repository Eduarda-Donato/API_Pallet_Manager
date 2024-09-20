package br.com.laserIot.palletManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.laserIot.palletManager.entity.PalletEntity;

public interface PalletRepository extends JpaRepository<PalletEntity,Long>{

}
