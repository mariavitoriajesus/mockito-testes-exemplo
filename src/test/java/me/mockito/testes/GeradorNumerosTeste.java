package me.mockito.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.GeradorDeNumeros;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GeradorNumerosTeste {
    @Test
    void validaGeracaoListaNumeros() {
        MockedStatic<GeradorDeNumeros> gerador = Mockito.mockStatic(GeradorDeNumeros.class);

        List<Integer> integers = List.of(1,2,3,4,5,6,7,8);
        gerador.when(() -> GeradorDeNumeros.gerarNumeroAleatorio(anyInt())).thenReturn(integers);

        Assertions.assertEquals(integers, GeradorDeNumeros.gerarNumeroAleatorio(8));
    }
    @Test
    void validaGeracaoSemInformarTamanho(){
        MockedStatic<GeradorDeNumeros> gerador = Mockito.mockStatic(GeradorDeNumeros.class);
        List<Integer> integers = List.of(10, 9,8,6);
        gerador.when(GeradorDeNumeros::gerarNumerosAleatorios).thenReturn(integers);
        Assertions.assertEquals(integers, GeradorDeNumeros.gerarNumerosAleatorios());
    }
}
