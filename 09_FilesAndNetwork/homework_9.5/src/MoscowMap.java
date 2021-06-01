import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MoscowMap {

    public static void main(String[] args) {
        String url = "https://www.moscowmap.ru/metro.html#lines";
        ArrayList<Line> map = parleLines(url);
        ArrayList<Connection> connections = parseConnection(url);
        printNumberOfStationOnLines(map);
        System.out.println("Общее количество переходов = " + connections.size());
        printMapToJSON(map, connections);

        //System.out.println(connections.size());
        //printConnections(connections);
        //printMap(map);

    }

    public static ArrayList<Line> parleLines(String url) {
        ArrayList<Line> lines = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).maxBodySize(0).get();
            Elements lineElements = doc.select("span[data-line]");
            lineElements.forEach(el -> {
                Elements stationElements = doc.select("div[data-line=" + el.attr("data-line") + "]");
                lines.add(new Line(el.text(), el.attr("data-line"), parseStation(stationElements.text(),
                        el.attr("data-line"))));
            });


            //a[data-metrost] > span.t-icon-metroln
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static ArrayList<Connection> parseConnection(String url) {
        ArrayList<Connection> connections = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).maxBodySize(0).get();
            Elements el = doc.select("a[data-metrost], div[data-line]");
            String lineFrom = "";
            for(int i = 0; i < el.size(); i++){
                if (el.get(i).tag().toString().equals("div")) {
                    lineFrom = el.get(i).attr("data-line");
                    continue;
                } else if (el.get(i).childrenSize() > 2) {
                    for (int j = 2; j < el.get(i).childrenSize(); j++) {
                        connections.add(parseConnection(el.get(i), j, lineFrom));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connections;
    }

    public static Connection parseConnection(Element element, int position, String lineFrom) {
        String nameFrom = element.child(1).text();
        String numberFrom = lineFrom;
        String nameTo = element.child(position).toString();
        nameTo = nameTo.substring(nameTo.indexOf("«") + 1, nameTo.indexOf("»"));
        String numberTo = element.child(position).attr("class");
        numberTo = numberTo.substring(numberTo.lastIndexOf("-") + 1, numberTo.length());

        return new Connection(new Station(nameFrom, numberFrom), new Station(nameTo, numberTo));

        //<span class="t-icon-metroln ln-14" title="переход на станцию «Бульвар Рокоссовского» МЦК">
    }


    public static ArrayList<Station> parseStation(String stationText, String lineCounter) {
        ArrayList<Station> stations = new ArrayList<>();
        String[] stationsArray = stationText.split("\\d\\d.|\\d.");
        for (int i = 0; i < stationsArray.length; i++) {
            if (i == 0) continue;
            stations.add(new Station(stationsArray[i], lineCounter));
        }
        return stations;
    }

    public static void printMap(ArrayList<Line> map) {
        int counter = 0;
        for (Line line : map) {
            counter = 1;
            System.out.println(line.getNumber() + ": " + line.getName());
            for (Station station : line.getStationsList()) {
                System.out.println("\t" + counter + ". " + station.getName());
                counter++;
            }
        }

    }

    public static void printConnections(ArrayList<Connection> connections) {
        for (Connection connection : connections) {
            connection.printConnection();
            System.out.println();
        }
    }

    public static void printMapToJSON(ArrayList<Line> map, ArrayList<Connection> connections) {
        JSONObject mapJSON = new JSONObject();
        JSONArray linesJSONArray = new JSONArray();
        JSONArray stationJSONArray = new JSONArray();
        JSONArray connectionJSONArray = new JSONArray();
        for (int i = 0; i < map.size(); i++) {
            linesJSONArray.add(map.get(i));
            JSONObject station = new JSONObject();
            station.put(map.get(i).getNumber(), map.get(i).getStationsList());
            stationJSONArray.add(station);
        }

        for(int i = 0; i < connections.size(); i++){
            JSONObject from = new JSONObject();
            JSONObject to = new JSONObject();
            from.put("line", connections.get(i).getFrom().getLineNumber());
            from.put("station", connections.get(i).getFrom().getName());
            to.put("line", connections.get(i).getTo().getLineNumber());
            to.put("station", connections.get(i).getTo().getName());
            JSONArray temp = new JSONArray();
            temp.add(from);
            temp.add(to);
            connectionJSONArray.add(temp);
        }

        mapJSON.put("line", linesJSONArray);
        mapJSON.put("station", stationJSONArray);
        mapJSON.put("connection", connectionJSONArray);



        String path = System.getProperty("user.dir") + "\\map.json";
        try (FileWriter file = new FileWriter(path)) {
            file.write(mapJSON.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printNumberOfStationOnLines(ArrayList<Line> map){
        System.out.println("Количетство станций на линиях: ");
        for(Line line : map){
            System.out.println(line.getName() + ": " + line.getNumberOfStation());
        }
    }

}
//#metrodata > div > div:nth-child(2) > div > p:nth-child(1) > a > span.t-icon-metroln.ln-14