package com.BigCase.NotaFiscal.repositories;

import com.BigCase.NotaFiscal.models.NotaFiscal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotaFiscalRepository extends CrudRepository<NotaFiscal, Integer> {
    List<NotaFiscal> findByIdentidade(String identidade);
}
