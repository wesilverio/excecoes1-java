
package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numQuarto;
    private Date checkIn;
    private Date checkOut;
    
    //static para não ser instanciado um novo SimpleDate toda vez q a aplicação precisar
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
        this.numQuarto = numQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duracao(){
        long diferenca = checkOut.getTime() - checkIn.getTime();    //pega a diferença em milisegundos
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); //faz uso do tipo enumerado complexo pra converter em dias
    }
    
    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    
    @Override
    public String toString(){

        return "Room "
                + numQuarto
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duracao()
                + " noites";
    }
}
