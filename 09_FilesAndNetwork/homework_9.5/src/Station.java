import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class Station implements JSONAware {

    private String name;
    private String lineNumber;

    public Station(String name, String lineNumber){
        this.name = name;
        this.lineNumber = lineNumber;
    }

    public String getName(){
        return name;
    }

    public String getLineNumber(){
        return lineNumber;
    }
    @Override
    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"" + JSONObject.escape(name) + "\"");

        return sb.toString();
    }
}
