package me.mockito.testes;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {
    @Mock
    private PlataformaDeEnvio plataforma;
    @InjectMocks
    private ServicoEnvioEmail servico;
    @Captor
    private ArgumentCaptor<Email> emailCaptor;
    @Test
    public void validaEmailDadosCorretos(){
        String email = "jose.alve@provedor.com";
        String mensagem = "Mensagem de Teste 123";

        servico.enviaEmail(email, mensagem, true);
        Mockito.verify(plataforma).enviarEmail(emailCaptor.capture());

        Email emailCapto = emailCaptor.getValue();
        Assertions.assertEquals(Formato.HTML, emailCapto.getFormato());

    }
}
