package client;

import proxy.BanqueServices;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        BanqueServices proxy = new BanqueWS().getBanqueServicesPort(); //intemidiaire pour discuter avec un autre serveur
        System.out.println("conversion de  330 € en MAD donne: "+proxy.conversionEuroToMAD(330));

        Compte cp = proxy.getCompte(3);
        System.out.println("Compte avec code 3: ");
        System.out.println("--------------------------------------------");
        System.out.printf("%-10s | %-10s | %-20s%n", "CODE", "SOLDE", "DATE CREATION");
        System.out.println("--------------------------------------------");
        System.out.printf("%-10d | %-10.2f | %-20s%n",
                cp.getCode(), cp.getSolde(), cp.getDateCreation().toString());

        List<Compte> compteList = proxy.listComptes();

        System.out.println("Liste des comptes: ");
        System.out.println("--------------------------------------------");
        System.out.printf("%-10s | %-10s | %-20s%n", "CODE", "SOLDE", "DATE CREATION");
        System.out.println("--------------------------------------------");
        compteList.forEach(compte->{
        System.out.printf("%-10d | %-10.2f | %-20s%n",
                compte.getCode(), compte.getSolde(), compte.getDateCreation().toString());

        });


    }
}
