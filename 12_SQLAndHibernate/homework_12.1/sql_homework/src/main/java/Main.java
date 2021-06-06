import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String password = "erapam12";

        try {
            String req = "SELECT \n" +
                    "\tpl.course_name course_name,\n" +
                    "\t(SELECT COUNT(*) \n" +
                    "\t FROM PurchaseList pl1 \n" +
                    "     WHERE pl1.course_name = pl.course_name)  / ((MAX(MONTH(pl.subscription_date)) - MIN(MONTH(pl.subscription_date)) + 1)) avg_purchase\n" +
                    "FROM PurchaseList pl\n" +
                    "group by pl.course_name;";
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(req);

            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
