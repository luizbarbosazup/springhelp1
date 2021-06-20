package br.com.zupedu.spring01.controller;

import br.com.zupedu.spring01.AlunoRepository;
import br.com.zupedu.spring01.controller.DTO.AlunoRequest;
import br.com.zupedu.spring01.controller.DTO.AlunoResponse;
import br.com.zupedu.spring01.model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public AlunoResponse salvaAluno(@RequestBody @Valid AlunoRequest alunoRequest){

        System.out.println(alunoRequest);
        Aluno alunoSalvo = repository.save(alunoRequest.toAluno());

        return new AlunoResponse(alunoSalvo.getNome(),alunoSalvo.getEmail());

    }

    @GetMapping("/{alunoId}")
    public ResponseEntity<AlunoResponse> buscaAlunoPorID(@PathVariable Long alunoId){
        Optional<Aluno> aluno = repository.findById(alunoId);

        if(aluno.isPresent()){
            return ResponseEntity.ok(new AlunoResponse(aluno.get().getNome(), aluno.get().getEmail()));
        }

        return ResponseEntity.notFound().build();

    }

}
