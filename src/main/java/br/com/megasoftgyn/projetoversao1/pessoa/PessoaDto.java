package br.com.megasoftgyn.projetoversao1.pessoa;

public class PessoaDto {
    
    private Long id;
    
    private String nome;
    
    private String telefone;
    
    public PessoaDto(final Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.telefone = pessoa.getTelefone();
    }
    
    public PessoaDto(final String nome, final String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public PessoaDto() {
        
    }
    
    public Pessoa build() {
        return new Pessoa(this.nome, this.telefone);
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
    
}
