public class Main {
    public static void main(String[] args) {
        String[][] array = new String[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
               if(i == j) array[i][j] = "X";
               else if(i + j == array.length - 1) array[i][j] = "X";
               else array[i][j] = " ";
            }

        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}


