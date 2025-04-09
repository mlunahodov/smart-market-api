package br.com.fiap.smartmarket.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.smartmarket.model.Setor;
import br.com.fiap.smartmarket.repository.SetorRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseSeeder {

    @Autowired
    private SetorRepository setorRepository;


    @PostConstruct
    public void init(){
        setorRepository.saveAll(
            List.of(
                Setor.builder().name("Educação").icon("Book").build(),
                Setor.builder().name("Lazer").icon("Dices").build(),
                Setor.builder().name("Transporte").icon("Bus").build()));

    }
    
}
