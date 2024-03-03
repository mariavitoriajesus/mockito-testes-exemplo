package me.mockito.testes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Conta;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTeste {
    @Spy
    private Conta conta= new Conta(3000);

    @Test
    void verificarChamadoMetodoDebita(){
        conta.pagarBoleto(300);
        Mockito.verify(conta).debita(300);
    }
    @Test
    void verificaNadaChamado(){
        Mockito.verifyNoInteractions(conta);
    }
    @Test
    void verificaOrdemChamada(){
        InOrder inOrder = Mockito.inOrder(conta);
        conta.pagarBoleto(300);
        conta.debita(300);
        conta.enviarCredito(300);
        inOrder.verify(conta).pagarBoleto(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviarCredito(300);
    }

    void validaQuantidadeVezesMetodoChamado() {
        conta.validaSaldo(100);
        conta.validaSaldo(100);
        conta.validaSaldo(100);

        Mockito.verify(conta, Mockito.times(3)).validaSaldo(100);
    }
}
