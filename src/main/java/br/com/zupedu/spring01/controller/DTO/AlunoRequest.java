package br.com.zupedu.spring01.controller.DTO;

import br.com.zupedu.spring01.model.Aluno;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AlunoRequest {
    @NotBlank @Size(max = 30)
    private String nome;
    @NotBlank @Email @Size(max = 30)
    private String email;
    @Min(18)
    private int idade;

    public AlunoRequest(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public Aluno toAluno(){
        return new Aluno(nome, email,idade);
    }
}
