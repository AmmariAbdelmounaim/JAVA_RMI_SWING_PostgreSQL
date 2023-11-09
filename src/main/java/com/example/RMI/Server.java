package com.example.RMI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
@SpringBootApplication
public class Server {
    public static void main(String[] args){
        try {
            ApplicationContext applicationContext = SpringApplication.run(Server.class, args);
            BankManagerImpl obj = applicationContext.getBean(BankManagerImpl.class);



            Registry registry = LocateRegistry.createRegistry(1099);

            registry.bind("BankManagerService", obj);

            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Exception serveur RMI: " + e.toString());
            e.printStackTrace();
        }
    }

}