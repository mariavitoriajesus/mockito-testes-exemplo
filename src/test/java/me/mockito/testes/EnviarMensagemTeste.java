package me.mockito.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.EnviarMensagem;
import org.mockito.Mensagem;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {
    @Spy
    EnviarMensagem enviarMensagem = new EnviarMensagem();

    void adicionarMensagem(){
        Mensagem mensagem = new Mensagem("Olá mundo!");

        enviarMensagem.adicionarMensagem(mensagem);
        verify(enviarMensagem).adicionarMensagem(mensagem);

        Assertions.assertEquals(1, enviarMensagem.getMensagems().size());
    }
}
