package br.com.megasoftgyn.projetoversao1.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
    @Column(name = "nome", updatable = true, nullable = false)
    private String nome;
    
    @Column(name = "telefone", updatable = true, nullable = false)
    private String telefone;
    
    public Pessoa() {
        
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }
    
}
