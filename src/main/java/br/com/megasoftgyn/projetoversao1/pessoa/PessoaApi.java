package br.com.megasoftgyn.projetoversao1.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/pessoa")
public class PessoaApi {
    
    @Autowired
    private PessoaService pessoaService;
    
    @GetMapping
    public String imprimirMensagem() {
        return "Eai lindão";
    }
    
    @GetMapping(path = "todas")
    public List<PessoaDto> listar() {
        return this.pessoaService.listar();
    }
    
    @PostMapping
    public Long adicionar(@RequestBody final PessoaDto dto) {
        return this.pessoaService.adicionar(dto);
    }
}
