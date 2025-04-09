package br.com.fiap.smartmarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.convert.DataSizeUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Setor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "o nome é obrigatório")
    @Size(min = 3, max = 255, message = "deve ter pelo menos 3 letras")
    private String name;

    @NotBlank(message = "o ícone é obrigatório")
    private String icon;
}
