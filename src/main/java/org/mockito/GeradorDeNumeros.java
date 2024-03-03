package org.mockito;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

public class GeradorDeNumeros {
    private static SplittableRandom random = new SplittableRandom();

    private GeradorDeNumeros(){     }

    public static List<Integer> gerarNumeroAleatorio(int tamanhoLista){
        return random.ints().boxed().limit(tamanhoLista).collect(Collectors.toList());
    }

    public static List<Integer> gerarNumerosAleatorios(){
        return random.ints().boxed().limit(random.nextInt(10)).collect(Collectors.toList());
    }
}
