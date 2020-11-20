import java.text.DecimalFormat;

public class Main {

    public static final int PATIENT_COUNT = 30;
    public static final int MIN_TEMP = 32;
    public static final int MAX_TEMP = 40;
    public static final float MIN_TEMP_HEALTHY = (float) 36.2;
    public static final float MAX_TEMP_HEALTHY = (float) 36.9;

    public static void main(String[] args) {
        float[] patientTemperature = new float[PATIENT_COUNT];

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        System.out.println("Температуры пациентов: ");
        for (int i = 0; i < patientTemperature.length; i++) {
            patientTemperature[i] = MIN_TEMP + (float) Math.random() * (MAX_TEMP - MIN_TEMP) ;
            System.out.print(decimalFormat.format(patientTemperature[i]) + " ");
        }
        System.out.println("\nСредняя температура\n" + averageValue(patientTemperature));

        System.out.println("Количество здоровых: \n" + amountOfHealthy(patientTemperature));



    }

    public static float averageValue(float[] array){
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result/ array.length;
    }

    public static int amountOfHealthy(float[] array){

        int amount = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] >= MIN_TEMP_HEALTHY && array[i] >= MAX_TEMP_HEALTHY) amount++;
        }
        return amount;
    }
}
