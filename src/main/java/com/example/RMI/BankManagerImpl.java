package com.example.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankManagerImpl extends UnicastRemoteObject implements BankManager {

    @Autowired
    private AccountRepository repository;

    protected BankManagerImpl() throws RemoteException {
        super();
    }

    @Override
    public void creerCompte(String id, double somme) throws RemoteException {
        if (repository.existsById(Integer.parseInt(id))) {
            throw new IllegalStateException("Account already exists");
        }
        Account account = new Account();
        account.setId(id);
        account.setBalance(somme);
        repository.save(account);
    }

    @Override
    public void ajouter(String id, double somme) throws RemoteException {
        Account account = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.setBalance(account.getBalance() + somme);
        repository.save(account);
    }

    @Override
    public void retirer(String id, double somme) throws RemoteException {
        Account account = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        if (account.getBalance() < somme) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - somme);
        repository.save(account);
    }

    @Override
    public double consulterSolde(String id) throws RemoteException {
        Account account = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        return account.getBalance();
    }

    @Override
    public void transfererSolde(String id_C, String id_D, double somme) throws RemoteException {
        Account accountA = repository.findById(id_C)
                .orElseThrow(() -> new IllegalArgumentException("Source account not found"));
        Account accountC = repository.findById(id_D)
                .orElseThrow(() -> new IllegalArgumentException("Destination account not found"));

        if (accountA.getBalance() < somme) {
            throw new IllegalArgumentException("Insufficient funds in source account");
        }
        accountA.setBalance(accountA.getBalance() - somme);
        accountC.setBalance(accountC.getBalance() + somme);

        repository.save(accountA);
        repository.save(accountC);
    }
}
