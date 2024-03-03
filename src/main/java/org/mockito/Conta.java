package org.mockito;

public class Conta {
    private int saldo;

    public Conta(int saldo){
        this.saldo = saldo;
    }

    public void pagarBoleto(int valorApagar){
        validaSaldo(valorApagar);
        debita(valorApagar);
        enviarCredito(valorApagar);
    }

    public void validaSaldo(int valorApagar){
        if (valorApagar > saldo){
            throw new IllegalStateException("Saldo insufuciente");
        }
    }

    public void debita(int valorApagar) {
        this.saldo = this.saldo - valorApagar;
    }

   public void enviarCredito(int valorApagar){

    }

}
