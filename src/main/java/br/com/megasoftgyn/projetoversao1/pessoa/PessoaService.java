package br.com.megasoftgyn.projetoversao1.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public List<PessoaDto> listar() {
        return this.pessoaRepository.listar();
    }
}
