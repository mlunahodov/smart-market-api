package br.com.fiap.smartmarket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.smartmarket.model.Setor;
import br.com.fiap.smartmarket.repository.SetorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("setor")
public class SetorController {

    private final Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private SetorRepository repository;

    @GetMapping
    public List<Setor> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Setor create(@RequestBody @Valid Setor setor) {
        log.info("Cadastrando setor " + setor.getName());
        return repository.save(setor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Setor> get(@PathVariable Long id) {
        log.info("Buscando setor " + id);
        return ResponseEntity.ok(getSetor(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Setor> delete(@PathVariable Long id) {
        log.info("Deletando setor " + id);
        repository.delete(getSetor(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Setor> update(@PathVariable Long id, @RequestBody @Valid Setor setor) {
        log.info("Atualizando setor " + id + " com " + setor);

        getSetor(id);
        setor.setId(id);
        repository.save(setor);
        return ResponseEntity.ok(setor);
    }

    private Setor getSetor(Long id) {
        return repository.findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Setor não encontrado")
                );
    }

}
