package org.mockito;

public class Email {
    private String enderecoemail, mensagem;
    private Formato formato;

    public Email(String enderecoemail, String mensagem, Formato formato) {
        this.enderecoemail = enderecoemail;
        this.mensagem = mensagem;
        this.formato = formato;
    }

    public String getEnderecoemail() {
        return enderecoemail;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Formato getFormato() {
        return formato;
    }
}
