import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {


    StationIndex stationIndex;
    RouteCalculator calculator;
    List<Station> stations;
    List<Station> route;

    @Override
    protected void setUp() throws Exception {

        stationIndex = new StationIndex();
        Line line1 = new Line(1, "first");
        Line line2 = new Line(2, "second");
        Line line3 = new Line(3, "third");
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stations = new ArrayList<>() {
            {
                add(new Station("Нулева", line1));
                add(new Station("Первая", line1));
                add(new Station("Вторая", line2));
                add(new Station("Третья", line2));
                add(new Station("Четвертая", line2));
                add(new Station("Пятая", line3));
                add(new Station("Шестая", line3));
            }
        };
        line1.addStation(stations.get(0));
        line1.addStation(stations.get(1));
        line2.addStation(stations.get(2));
        line2.addStation(stations.get(3));
        line2.addStation(stations.get(4));
        line3.addStation(stations.get(5));
        line3.addStation(stations.get(6));

       // System.out.println(line1.getStations());
        List<Station> connectionBetweenFirstSecond = new ArrayList<>(){{
            add(stations.get(1));
            add(stations.get(2));
        }};
        List<Station> connectionBetweenSecondThird = new ArrayList<>(){{
            add(stations.get(4));
            add(stations.get(5));
        }};
        stationIndex.addConnection(connectionBetweenFirstSecond);
        stationIndex.addConnection(connectionBetweenSecondThird);
        calculator = new RouteCalculator(stationIndex);

        route = new ArrayList<>(){{
            add(stations.get(0));
            add(stations.get(1));
            add(stations.get(2));
        }};
    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 6;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute(){
        Station from = stations.get(1);
        Station to = stations.get(3);
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = new ArrayList<>(){{
            add(stations.get(1));
            add(stations.get(2));
            add(stations.get(3));
        }};

        assertEquals(expected, actual);
    }
    public void testGetRouteWithOneConnection(){
        Station from = stations.get(0);
        Station to = stations.get(4);
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = new ArrayList<>(){{
            add(stations.get(0));
            add(stations.get(1));
            add(stations.get(2));
            add(stations.get(3));
            add(stations.get(4));
        }};

        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections(){
        Station from = stations.get(0);
        Station to = stations.get(6);
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = new ArrayList<>(){{
            add(stations.get(0));
            add(stations.get(1));
            add(stations.get(2));
            add(stations.get(3));
            add(stations.get(4));
            add(stations.get(5));
            add(stations.get(6));
        }};

        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine(){
        Station from = stations.get(0);
        Station to = stations.get(1);
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = new ArrayList<>(){{
            add(stations.get(0));
            add(stations.get(1));
        }};

        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
