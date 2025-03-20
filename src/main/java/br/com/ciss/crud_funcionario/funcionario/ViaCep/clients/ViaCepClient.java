package br.com.ciss.crud_funcionario.funcionario.ViaCep.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "via-cep", url = "${viacep.url}")
public interface ViaCepClient {

    @GetMapping("/ws/{cep}/json/")
    ViaCepDto buscaDadosEndereco(@PathVariable("cep") String cep);
}
