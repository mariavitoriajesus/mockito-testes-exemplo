package me.mockito.testes;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ApiDosCorreios;
import org.mockito.DadosLocalizacao;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ApiDosCorreiosTeste {
    @Mock
    private ApiDosCorreios apiDosCorreios;

    @Test
    void retornaObjetoQuandoEspecificoValorEhPassado() {
        when(apiDosCorreios.buscaDadosComCep(anyString())).thenReturn(null);
        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosComCep("161761");
        assertNull(dadosLocalizacao);
    }

    @Test
    void retornaObjetoQuandoEspecificoValorEhPassado2() {
        when(apiDosCorreios.buscaDadosComCep("78787878")).thenReturn(new DadosLocalizacao("AM", "Manaus", "Rua Grajaúna", "casa", "Lago Azul"));
        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosComCep("78787878");
        assertEquals("AM", dadosLocalizacao.getUf());
    }

}
