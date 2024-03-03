package org.mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnviarMensagem {
    private List<Mensagem> mensagems = new ArrayList<>();

    public void adicionarMensagem(Mensagem mensagem){
        this.mensagems.add(mensagem);
    }


    public List<Mensagem> getMensagems() {
        return Collections.unmodifiableList(this.mensagems);
    }
}
