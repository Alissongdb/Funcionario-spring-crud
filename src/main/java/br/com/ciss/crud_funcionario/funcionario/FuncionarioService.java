package br.com.ciss.crud_funcionario.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario salvarFuncionario(Funcionario funcionario) {

        List<String> cargosPermitidos = Arrays.asList("desenvolvedor", "qa", "po", "suporte");

        if (!cargosPermitidos.contains(funcionario.getCargo())) {
            throw new RuntimeException("O cargo precisa ser: " + cargosPermitidos);
        }

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
