public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    int sum = sumDigits(null);

    System.out.println(sum);
  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

  public static int sumDigits(Integer number) {
    //@TODO: write code here and delete TODO line
   // if(number.equals(null)) return 0;
    if(number == null) return -1;
    String num = number.toString();
    int length  = num.length();
    int result = 0;
    while(length != 0){
      result = result + num.charAt(length - 1) - 48;
       length--;
    }
    return result;
  }
}
