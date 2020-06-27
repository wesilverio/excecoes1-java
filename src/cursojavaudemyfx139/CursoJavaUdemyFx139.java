
package cursojavaudemyfx139;

import model.entidades.Reserva;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.exceptions.DomainException;

public class CursoJavaUdemyFx139 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            System.out.print("Número do quarto: ");
            int numQuarto = sc.nextInt();
            System.out.print("Data do Check-In (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Data do Check-Out (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());        

            Reserva reserva = new Reserva(numQuarto, checkin, checkout);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com a data para atualizar a reserva: ");
            System.out.print("Data do Check-In (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Data do Check-Out (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next()); 

            reserva.updateDates(checkin, checkout);
            System.out.println("Reserva: " + reserva);
        } catch(ParseException e){
            System.out.println("Formato de Data Inválida");
        } catch(DomainException e){
            System.out.println("Erro na Reserva: " + e.getMessage());
        }
        sc.close();
    }
    
}
