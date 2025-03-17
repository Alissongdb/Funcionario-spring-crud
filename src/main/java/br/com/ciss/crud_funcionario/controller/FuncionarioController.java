package br.com.ciss.crud_funcionario.controller;

import br.com.ciss.crud_funcionario.Entity.Funcionario;
import br.com.ciss.crud_funcionario.dtos.FuncionarioDto;
import br.com.ciss.crud_funcionario.service.FuncionarioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    public FuncionarioDto salvarFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) {
        Funcionario funcionario = modelMapper.map(funcionarioDto, Funcionario.class);
        Funcionario funcionarioSalvo = service.salvarFuncionario(funcionario);
        return modelMapper.map(funcionarioSalvo, FuncionarioDto.class);
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




}
