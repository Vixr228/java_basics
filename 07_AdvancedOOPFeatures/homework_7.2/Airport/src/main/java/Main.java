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
        int twoHoursMillis = 7200000;
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        List<Flight> flightList = new ArrayList<>();

       airport.getTerminals().stream()
              .forEach(t -> t.getFlights().stream()
                .filter(flight -> flight.getDate().getTime() - System.currentTimeMillis() <= twoHoursMillis)
                      .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                        .forEach(f -> flightList.add(f)));
        return flightList;

    
    }

}