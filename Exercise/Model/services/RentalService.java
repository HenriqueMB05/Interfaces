package Exercise.Model.services;

import Exercise.Model.entities.carRental;
import Exercise.Model.entities.Invoice;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }


    public void processInvoice(carRental carrental){

        double minutes = Duration.between(carrental.getStart(), carrental.getFinish()).toMinutes();

        double hours = minutes/60;
        double basicPayment;
        if(hours <= 12){
            basicPayment = pricePerHour * Math.ceil(hours);
        }
        else{
            basicPayment = pricePerDay * Math.ceil(hours/24);
        }

        double tax = taxService.tax(basicPayment);
        carrental.setInvoice(new Invoice(basicPayment,tax));
    }
}
