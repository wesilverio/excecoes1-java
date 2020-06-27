
package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reserva {
    private Integer numQuarto;
    private Date checkIn;
    private Date checkOut;
    
    //static para não ser instanciado um novo SimpleDate toda vez q a aplicação precisar
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numQuarto, Date checkIn, Date checkOut) throws DomainException {
        //Programação defensiva, procura tratar as excecções no começo do método
        if (!checkOut.after(checkIn)){
            throw new DomainException("Data de check-out não pode ser anterior a data de check-in");
        }
        
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
    
    public void updateDates(Date checkIn, Date checkOut) throws DomainException{
        Date agora = new Date();
        if(checkIn.before(agora) || checkOut.before(agora)){
            //excecção usada qdo os argumentos passados para um método são inválidos
            throw new DomainException("As datas para atualização devem ser datas futuras");
        }
        if (!checkOut.after(checkIn)){
            throw new DomainException("Data de check-out não pode ser anterior a data de check-in");
        }

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
