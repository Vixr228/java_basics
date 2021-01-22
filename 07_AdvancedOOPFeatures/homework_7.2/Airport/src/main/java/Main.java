import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        List<Flight> flightList = new ArrayList<>();

        Date dat0=new Date();
        Date dat=new Date();
        dat.setTime(dat.getTime()+1000*60*60*2);

       airport.getTerminals().stream()
              .forEach(t -> t.getFlights().stream()
                .filter(flight -> flight.getDate().before(dat)
                        && flight.getDate().after(dat0)
                        && flight.getType().equals(Flight.Type.DEPARTURE))
                .forEach(f -> flightList.add(f)));

       return flightList;

    
    }

}