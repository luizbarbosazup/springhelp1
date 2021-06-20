package br.com.zupedu.spring01.controller.DTO;

public class AlunoResponse {

    private String nome;
    private String email;

    public AlunoResponse(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
