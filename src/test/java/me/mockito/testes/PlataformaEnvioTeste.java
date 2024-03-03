package me.mockito.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlataformaEnvioTeste {
    @Mock
    private PlataformaDeEnvio plataformaDeEnvio;

    void tentaEnviarEmailFalha(){
        Mockito.doThrow(IllegalAccessError.class).when(plataformaDeEnvio).enviarEmail(Mockito.any());

        Assertions.assertThrows(IllegalStateException.class, () -> plataformaDeEnvio.enviarEmail(new Email("teste@teste.org", "Teste", Formato.TEXTO)));

    }
}
