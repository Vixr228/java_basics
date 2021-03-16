import jdk.jshell.spi.ExecutionControl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Movements {
    public static int counter = 0;
    public static final int DESCRIPTION_INDEX = 5;
    public static final int INCOME_INDEX = 6;
    public static final int EXPENSE_INDEX = 7;
    List<Payment> paymentList;

    public Movements(String pathMovementsCsv) {
        paymentList = new ArrayList<>();
        paymentList = parseCsvFile(pathMovementsCsv);

    }

    public double getExpenseSum() {
        double expenseSum = 0;
        for(Payment curr : paymentList){
            expenseSum += curr.expense;
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0;
        for(Payment curr : paymentList){
            incomeSum += curr.income;
        }
        return incomeSum;
    }

    public List<Payment> parseCsvFile(String path){
        List<Payment> paymentList = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Paths.get(path));
            boolean flag = false;
            for(String line : lines){
                if(!flag){
                    flag = true;
                    continue;
                }
                String[] fragments = line.split(",");
                if(fragments.length == 9) fragments = editQuotes(fragments);
                if(fragments.length != 8 && !(fragments.length == 9 && fragments[8] == null)){
                    System.out.println("Wrong line");
                    continue;
                }
                paymentList.add(new Payment(editDescription(fragments[DESCRIPTION_INDEX]),
                        Double.parseDouble(fragments[INCOME_INDEX]),
                        Double.parseDouble(fragments[EXPENSE_INDEX])));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return paymentList;
    }

    public String[] editQuotes(String[] fragments){
        if(fragments[8].contains("\"")) {
            fragments[7] = fragments[7] + "." + fragments[8];
            fragments[7] = fragments[7].replaceAll("\"", "");
            fragments[8] = null;
        } else {
            fragments[6] = fragments[6] + "." + fragments[7];
            fragments[6] = fragments[6].replaceAll("\"", "");
            fragments[7] = fragments[8];
            fragments[8] = null;
        }
        return fragments;
    }
    public String editDescription(String data){
        String description = data.substring(data.indexOf("  ")).trim();
        description = description.substring(0, description.indexOf("   ")).trim();
        return description;
    }

    public void expensesByOrganization(){
        Map<String, Double> map = paymentList.stream()
                .collect(Collectors.groupingBy(Payment::getPaymentDescription,
                        Collectors.summingDouble(Payment::getExpense)));

       // map.entrySet().stream().forEach(e-> System.out.println(e + " руб"));
        for (String keys : map.keySet())
        {
            System.out.println(keys + "\t\t"+ map.get(keys));
        }
    }

}
