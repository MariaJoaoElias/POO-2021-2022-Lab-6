package views;

import controllers.Bank;

import java.util.Scanner;

public class CLI {
    public CLI() {
        Bank bank = new Bank();
        final var scanner = new Scanner(System.in);
        while(true) {
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
                        System.out.println("Cliente existente");
                    }
                    else {
                        bank.registerClient(clientId, clientIdType, birthdate, email, phoneNumber, clientName, address);
                        System.out.println("Cliente registado com sucesso.");
                    }
                    break;
                default:
                    System.out.println("Instrução inválida.");
            }

        }

    }
}
