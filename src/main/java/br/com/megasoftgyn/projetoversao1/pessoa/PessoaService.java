package br.com.megasoftgyn.projetoversao1.pessoa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public List<PessoaDto> listar() {
        return this.pessoaRepository.listar();
    }
    
    @Transactional
    public Long adicionar(final PessoaDto dto) {
        final Pessoa entidade = dto.build();
        this.pessoaRepository.adicionar(entidade);
        return entidade.getId();
    }
    
    @Transactional
    public void excluir(final Long id) {
        this.pessoaRepository.excluir(id);
    }
    
    @Transactional
    public PessoaDto buscar(final Long id) {
        return new PessoaDto(this.pessoaRepository.buscar(id));
    }
    
}
