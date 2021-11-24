package views;

import controllers.Bank;

import java.util.Scanner;

public class CLI {
    public CLI() {
        Bank bank = new Bank();
        while(true) {
            final var scanner = new Scanner(System.in);
            final var line = scanner.nextLine();
            if(line.isBlank()) {
                break;
            }
            final var commands = line.split(" ");


            switch(commands[0]) {
                case "RC":
                    final var clientId = commands[1];
                    final var clientIdType = commands[2];
                    final var birthdate = commands[3];
                    final var email = commands[4];
                    final var phoneNumber = commands[5];
                    final var clientName = scanner.nextLine();
                    final var address = scanner.nextLine();
                    if(bank.hasClient(clientId, clientIdType)) {
                        System.out.println("Cliente existente.");
                    }
                    else {
                        bank.registerClient(clientId, clientIdType, clientName, birthdate, email, phoneNumber, address);
                        System.out.println("Cliente registado com sucesso.");
                    }
                    break;
                case "AC":
                    final var ACclientId = commands[1];
                    final var ACclientIdType = commands[2];
                    final var ACbirthdate = commands[3];
                    final var ACemail = commands[4];
                    final var ACphoneNumber = commands[5];
                    final var ACclientName = scanner.nextLine();
                    final var ACaddress = scanner.nextLine();
                    if(!bank.hasClient(ACclientId, ACclientIdType)) {
                        System.out.println("Cliente inexistente.");
                    }
                    else {
                        bank.changeClient(ACclientId, ACclientIdType, ACclientName, ACbirthdate, ACemail, ACphoneNumber, ACaddress);
                        System.out.println("Dados de cliente alterados com sucesso.");
                    }
                    break;
                default:
                    System.out.println("Instrução inválida.");
            }

        }
    }
}
