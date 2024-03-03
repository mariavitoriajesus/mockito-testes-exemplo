package me.mockito.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListaTest {
    @Mock
    private List<String> letras;

    @Test
    void adicionarItensNaLista(){
        Mockito.when(letras.get(0)).thenReturn("s");

        Assertions.assertEquals("B", letras.get(0));
    }
}
