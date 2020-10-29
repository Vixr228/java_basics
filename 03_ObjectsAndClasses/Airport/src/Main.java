import com.skillbox.airport.Airport;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        System.out.println(airport.getAllAircrafts().toString());
        int airportSize = airport.getAllAircrafts().size();
        System.out.println("Size of airport: " + airportSize);
        //System.out.println(airport.getTerminals().toString());
    }
}
