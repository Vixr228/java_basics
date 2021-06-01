import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Connection implements JSONAware {

    private Station from;
   private Station to;
    ArrayList<Station> connection;

    Connection(Station from, Station to){
        this.from = from;
        this.to = to;
        connection = new ArrayList<>();
        connection.add(from);
        connection.add(to);
    }

    public Station getFrom(){
        return from;
    }

    public Station getTo(){
        return to;
    }

    public ArrayList<Station> getConnection(){
        return connection;
    }

    public void printConnection(){
        System.out.println("{");
        System.out.println("\"line\": " + from.getLineNumber());
        System.out.println("\"station\": " + from.getName());
        System.out.println("},");
        System.out.println("{");
        System.out.println("\"line\": " + to.getLineNumber());
        System.out.println("\"station\": " + to.getName());
        System.out.println("}");
    }

    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"line\"");
        sb.append(":");
        sb.append("\"" + JSONObject.escape(from.getLineNumber()) + "\"");
        sb.append(",");
        sb.append("\"station\"");
        sb.append(":");
        sb.append("\"" + JSONObject.escape(from.getName()) + "\"");
        sb.append("}");
        sb.append(",");
        sb.append("{");
        sb.append("\"line\"");
        sb.append(":");
        sb.append("\"" + JSONObject.escape(to.getLineNumber()) + "\"");
        sb.append(",");
        sb.append("\"station\"");
        sb.append(":");
        sb.append("\"" + JSONObject.escape(to.getName()) + "\"");
        sb.append("}");
        return sb.toString();
    }
}


//      [
//        {
//        "line": 2,
//        "station": "Невский проспект"
//        },
//        {
//        "line": 3,
//        "station": "Гостиный двор"
//        }
//      ],