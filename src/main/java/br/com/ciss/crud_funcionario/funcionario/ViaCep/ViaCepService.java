package br.com.ciss.crud_funcionario.funcionario.ViaCep;

import br.com.ciss.crud_funcionario.funcionario.ViaCep.clients.ViaCepClient;
import br.com.ciss.crud_funcionario.funcionario.ViaCep.clients.ViaCepDto;
import br.com.ciss.crud_funcionario.funcionario.exceptions.IllegalArgumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final ViaCepClient viaCepClient;

    public ViaCepDto buscarDadosEndereco(String cep) {
        return viaCepClient.buscaDadosEndereco(processarCep(cep));
    }

    private String processarCep(String cep) {
        String cepFormatado = cep.replace(" ", "").replace("-", "");

        if (!cepFormatado.matches("\\d+") || !Objects.equals(cepFormatado.length(), 8)) {
            throw new IllegalArgumentException("O Cep contem caracteres invalidos, verifique!");
        }

        return cepFormatado;

    }
}
