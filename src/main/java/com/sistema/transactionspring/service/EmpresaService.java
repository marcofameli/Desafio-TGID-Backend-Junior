package com.sistema.transactionspring.service;

import com.sistema.transactionspring.domain.Empresa;
import com.sistema.transactionspring.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa criar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa buscarPorCnpj(String cnpj) {
        return empresaRepository.findByCnpj(cnpj);
    }

    public List<Empresa> buscarTodas() {
        return empresaRepository.findAll();
    }

    public void deletar(Long idEmpresa) {
        empresaRepository.deleteById(idEmpresa);

    }

    public void atualizarSaldo(Long idEmpresa, double valor) {
        Empresa empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));

        double novoSaldo = empresa.getSaldo() + valor;
        empresa.setSaldo(novoSaldo);
        empresaRepository.save(empresa);
    }

}
