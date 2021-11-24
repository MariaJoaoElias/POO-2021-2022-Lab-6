package views;

import controllers.Bank;

import java.util.Scanner;

public class CLI {
    public CLI() {
        Bank bank = new Bank();
        String clientId;
        String clientIdType;
        String birthdate;
        String email;
        String phoneNumber;
        String clientName;
        String address;

        while(true) {
            final var scanner = new Scanner(System.in);
            final var line = scanner.nextLine();
            if(line.isBlank()) {
                break;
            }
            final var commands = line.split(" ");


            switch(commands[0]) {
                case "RC":
                    clientId = commands[1];
                    clientIdType = commands[2];
                    birthdate = commands[3];
                    email = commands[4];
                    phoneNumber = commands[5];
                    clientName = scanner.nextLine();
                    address = scanner.nextLine();
                    if(bank.hasClient(clientId, clientIdType)) {
                        System.out.println("Cliente existente.");
                    }
                    else {
                        bank.registerClient(clientId, clientIdType, clientName, birthdate, email, phoneNumber, address);
                        System.out.println("Cliente registado com sucesso.");
                    }
                    break;
                case "AC":
                    clientId = commands[1];
                    clientIdType = commands[2];
                    birthdate = commands[3];
                    email = commands[4];
                    phoneNumber = commands[5];
                    clientName = scanner.nextLine();
                    address = scanner.nextLine();
                    if(!bank.hasClient(clientId, clientIdType)) {
                        System.out.println("Cliente inexistente.");
                    }
                    else {
                        bank.changeClient(clientId, clientIdType, clientName, birthdate, email, phoneNumber, address);
                        System.out.println("Dados de cliente alterados com sucesso.");
                    }
                    break;
                default:
                    System.out.println("Instrução inválida.");
            }

        }
    }
}
