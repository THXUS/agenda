package br.com.megasoftgyn.projetoversao1.pessoa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class PessoaDto {
    
    private Long id;
    
    private String nome;
    
    private String telefone;
    
    private String serial;
    
    public PessoaDto(final Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.telefone = pessoa.getTelefone();
        this.serial = pessoa.getSerial();
    }
    
    public PessoaDto(final String nome, final String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public PessoaDto() {
        
    }
    
    public Pessoa build() {
        return new Pessoa(this.nome, this.telefone, this.serial);
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public String getSerial() {
        return this.serial;
    }
    
}
