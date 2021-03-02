package br.com.megasoftgyn.projetoversao1.pessoa;

public class PessoaDto {
    
    private final String nome;
    
    private final String telefone;
    
    public PessoaDto(final Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.telefone = pessoa.getTelefone();
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
}
