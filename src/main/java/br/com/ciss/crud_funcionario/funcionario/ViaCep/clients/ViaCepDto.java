package br.com.ciss.crud_funcionario.funcionario.ViaCep.clients;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViaCepDto {

        public String cep;
        public String logradouro;
        public String complemento;
        public String unidade;
        public String bairro;
        public String localidade;
        public String uf;
        public String estado;
        public String regiao;
        public String ibge;
        public String gia;
        public String ddd;
        public String siafi;
}

