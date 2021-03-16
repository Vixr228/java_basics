import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final String PATH = "java_basics/09_FilesAndNetwork/files/movementList.csv";
    public static void main(String[] args) {

        Movements mov = new Movements(PATH);
        System.out.println("Сумма расходов: " + mov.getExpenseSum() + " руб.");
        System.out.println("Сумма доходов: " + mov.getIncomeSum() + " руб.");
        System.out.println("Суммы расходов по организациям:");
        mov.expensesByOrganization();

    }
}
