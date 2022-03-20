package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BancoServiceIF extends Remote {

    Conta pegarConta(String numero) throws RemoteException;
    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    Boolean removerConta(String numero) throws RemoteException;
    Boolean cadastrarConta(Conta conta) throws RemoteException;
}
