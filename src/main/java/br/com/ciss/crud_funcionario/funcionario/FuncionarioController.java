package br.com.ciss.crud_funcionario.funcionario;

import br.com.ciss.crud_funcionario.funcionario.ViaCep.ViaCepService;
import br.com.ciss.crud_funcionario.funcionario.ViaCep.clients.ViaCepDto;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ViaCepService viaCepService;


    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) {
            Funcionario funcionario = modelMapper.map(funcionarioDto, Funcionario.class);
            Funcionario funcionarioSalvo = service.salvarFuncionario(funcionario);

            if (funcionarioDto.getEmail() == null || funcionarioDto.getEmail().isEmpty()) {
                throw new IllegalArgumentException("Informe um email");
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
            }

    }

    @GetMapping
    public List<FuncionarioDto> buscarTodos() {
        List<Funcionario> funcionarios = service.buscarTodos();
        return modelMapper.map(funcionarios, List.class);
    }

    @GetMapping("/{id}")
    public FuncionarioDto buscarPorId(@PathVariable Long id) {
        Funcionario funcionario = service.buscarPorId(id);
        return modelMapper.map(funcionario, FuncionarioDto.class);
    }

    @PutMapping("/{id}")
    public FuncionarioDto atualizarFuncionario(@PathVariable Long id, @RequestBody @Valid FuncionarioDto funcionarioDto) {
        Funcionario funcionario = modelMapper.map(funcionarioDto, Funcionario.class);
        funcionario.setId(id);
        Funcionario funcionarioAtualizado = service.atualizarFuncionario(funcionario);
        return modelMapper.map(funcionarioAtualizado, FuncionarioDto.class);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Long id) {
        service.deletarFuncionario(id);
    }


    //VIA CEP
    @GetMapping("/endereco/{cep}")
    public ResponseEntity<ViaCepDto> buscarDadosCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok(viaCepService.buscarDadosEndereco(cep));
    }




}
