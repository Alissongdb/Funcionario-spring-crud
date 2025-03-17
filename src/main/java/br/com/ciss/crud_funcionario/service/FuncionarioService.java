package br.com.ciss.crud_funcionario.service;

import br.com.ciss.crud_funcionario.Entity.Funcionario;
import br.com.ciss.crud_funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public List<Funcionario> buscarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public void deletarFuncionario(Long id) {
        repository.deleteById(id);
    }

}
