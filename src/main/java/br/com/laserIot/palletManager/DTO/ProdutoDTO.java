package br.com.laserIot.palletManager.DTO;

import org.springframework.beans.BeanUtils;

import br.com.laserIot.palletManager.entity.ProdutoEntity;


public class ProdutoDTO {
    private Long id;
    private String name;
    private Integer count;
    private Integer EPC;

    public ProdutoDTO(ProdutoEntity produto){
        BeanUtils.copyProperties(produto,this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getEPC() {
        return EPC;
    }

    public void setEPC(Integer ePC) {
        EPC = ePC;
    }
}
