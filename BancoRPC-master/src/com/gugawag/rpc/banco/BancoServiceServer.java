package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas = new ArrayList<>();

    public BancoServiceServer() throws RemoteException {
        Conta c1 = new Conta("1", 100.0);
        Conta c2 = new Conta("2", 156.0);
        Conta c3 = new Conta("3", 950.0);

        contas.add(c1);
        contas.add(c2);
        contas.add(c3);
    }

    @Override
    public Conta pegarConta(String numero) {
        for(Conta conta: this.contas)
            if(conta.getNumero().equals(numero)) return conta;

        return null;
    }

    @Override
    public double saldo(String numero) throws RemoteException {
        Conta conta = this.pegarConta(numero);
        if(conta == null)  throw new RemoteException("Conta não encontrada");
        return conta.getSaldo();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public Boolean removerConta(String numero) throws RemoteException {
        for(Conta conta: this.contas)
            if(conta.getNumero().equals(numero)) return this.contas.remove(conta);
        return false;
    }

    @Override
    public Boolean cadastrarConta(Conta conta) {
        contas.add(conta);
        return true;
    }

}
