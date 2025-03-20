package br.com.ciss.crud_funcionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CrudFuncionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudFuncionarioApplication.class, args);
	}

}
