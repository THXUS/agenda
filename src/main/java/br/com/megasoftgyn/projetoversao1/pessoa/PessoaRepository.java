package br.com.megasoftgyn.projetoversao1.pessoa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepository {
    
    @Autowired
    private EntityManager entityManager;
    
    public List<PessoaDto> listar() {
        final StringBuilder sql = new StringBuilder();
        sql.append("select new br.com.megasoftgyn.projetoversao1.pessoa.PessoaDto(pe) from Pessoa pe");
        final TypedQuery<PessoaDto> typedQuery = this.entityManager.createQuery(sql.toString(), PessoaDto.class);
        return typedQuery.getResultList();
    }
}
