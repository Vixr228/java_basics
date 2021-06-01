import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Line implements JSONAware {

    private String name;
    private String number;
    private ArrayList<Station> stationsList;

    public Line(String name, String number) {
        this.name = name;
        this.number = number;
        stationsList = new ArrayList<>();
    }

    public Line(String name, String number, ArrayList<Station> station) {
        this.name = name;
        this.number = number;
        stationsList = station;
    }

    public int getNumberOfStation(){
        return stationsList.size();
    }
    public String getName(){
        return name;
    }

    public String getNumber(){
        return number;
    }

    public ArrayList<Station> getStationsList(){
        return stationsList;
    }
    public void addStation(ArrayList<Station> station){
        stationsList = station;
    }

    public void printStationList(){
        stationsList.forEach(System.out::println);
    }

    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"number\"");
        sb.append(":");
        sb.append("\"" + JSONObject.escape(number) + "\"");
        sb.append(",");
        sb.append("\"name\"");
        sb.append(":");
        sb.append("\"" + JSONObject.escape(name) + "\"");
        sb.append("}");
        return sb.toString();
    }
}
