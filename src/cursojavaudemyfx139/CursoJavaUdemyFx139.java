
package cursojavaudemyfx139;

import entidades.Reserva;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CursoJavaUdemyFx139 {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Número do quarto: ");
        int numQuarto = sc.nextInt();
        System.out.print("Data do Check-In (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Data do Check-Out (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.next());        
        
        if (!checkout.after(checkin)){
            System.out.println("Erro in reservation: Data de check-out não pode ser anterior a data de check-in");
        }else{
            Reserva reserva = new Reserva(numQuarto, checkin, checkout);
            System.out.println("Reserva: " + reserva);
            
            System.out.println();
            System.out.println("Entre com a data para atualizar a reserva: ");
            System.out.print("Data do Check-In (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Data do Check-Out (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next()); 
            
            String error = reserva.updateDates(checkin, checkout);
            if (error != null){
                System.out.println("Reserva erro: " + error);
            } else {
                System.out.println("Reserva: " + reserva);
            }
        }
        
        sc.close();
    }
    
}
