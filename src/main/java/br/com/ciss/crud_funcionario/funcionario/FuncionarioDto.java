package br.com.ciss.crud_funcionario.funcionario;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDto {

    private Long id;

    @Size(min = 3, max = 50)
    private String nome;

    @Size(min = 2, max = 50)
    private String sobrenome;

    private String email;

    private String nis;

    @NotNull
    private String cargo;

}
