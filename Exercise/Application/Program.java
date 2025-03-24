package Exercise.Application;

import Exercise.Model.entities.Vehicle;
import Exercise.Model.entities.carRental;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel: ");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Entre com o preço por hora: ");

        carRental cr = new carRental(start, finish, new Vehicle(carModel));

        System.out.print("Entre com o preço por dia: ");
        System.out.println("FATURA: ");
        System.out.print("Pagamento básico : ");
        System.out.print("Imposto: ");
        System.out.print("Pagamento Total: ");

        sc.close();
    }
}
