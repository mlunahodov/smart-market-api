package br.com.fiap.smartmarket.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.smartmarket.model.Setor;
import br.com.fiap.smartmarket.model.Transaction;
import br.com.fiap.smartmarket.repository.SetorRepository;
import br.com.fiap.smartmarket.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseSeeder {

    @Autowired
    private SetorRepository setorRepository;

    @Autowired 
    private TransactionRepository transactionRepository;

    @PostConstruct
    public void init() {
        var setor = List.of(
            Setor.builder().name("Educação").icon("Book").build(),
            Setor.builder().name("Lazer").icon("Dices").build(),
            Setor.builder().name("Transporte").icon("Bus").build(),
            Setor.builder().name("Moradia").icon("House").build(),
            Setor.builder().name("Saúde").icon("Heart").build()
        );

        setorRepository.saveAll(setor);

        var descriptions = List.of("Uber para faculdade", "Remédio", "Café especial", "Livro didático", "Cinema", "Bilhete Único", "Restaurante", "Faculdade", "Plano de Saúde", "Aluguel", "Conta de Água", "Conta de Luz", "Streaming");
        var transactions = new ArrayList<Transaction>();

        for(int i= 0; i<50; i++ ){
            transactions.add(Transaction.builder()
                .description(descriptions.get(new Random().nextInt(descriptions.size())))
                .amount(BigDecimal.valueOf(10 + new Random().nextDouble()*500))
                .date(LocalDate.now().minusDays(new Random().nextInt(30)))
                .type("out")
                .setor(setor.get(new Random().nextInt(setor.size())))
                .build()
            );
        }

        transactionRepository.saveAll(transactions);


    }

}
