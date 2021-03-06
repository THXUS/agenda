package br.com.megasoftgyn.projetoversao1.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", updatable = true, nullable = false)
    private String nome;
    
    @Column(name = "telefone", updatable = true, nullable = false)
    private String telefone;
    
    @Column(name = "serial", updatable = true, nullable = true)
    private String serial;
    
    public Pessoa() {
        
    }
    
    public Pessoa(final String nome, final String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public Pessoa(final String nome, final String telefone, final String serial) {
        this.nome = nome;
        this.telefone = telefone;
        this.serial = serial;
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
    
    public String getSerial() {
        return this.serial;
    }
    
    public void setSerial(final String serial) {
        this.serial = serial;
    }
    
}
