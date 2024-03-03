package me.mockito.testes;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyString;
@ExtendWith(MockitoExtension.class)
public class CadatrarPessoaTest {
    @Mock
    private ApiDosCorreios apiDosCorreios;

    @Mock
    private CadastrarPessoa cadastrarPessoa;

    void cadastrarPessoa(){
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Uberaba", "Rua Castro Alves", "Casa", "Nova Floresta");
        Mockito.when(apiDosCorreios.buscaDadosComCep(anyString())).thenReturn(dadosLocalizacao);

        Pessoa jose = cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300");

        DadosLocalizacao enderecoJose = jose.getEndereco();
        assertEquals(dadosLocalizacao.getBairro(), enderecoJose.getBairro());
        assertEquals(dadosLocalizacao.getCidade(), enderecoJose.getCidade());
        assertEquals(dadosLocalizacao.getUf(), enderecoJose.getUf());
    }

    void tentaCadastrarPessoaFalha() {
        Mockito.when(apiDosCorreios.buscaDadosComCep(anyString())).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300"));
    }
}
