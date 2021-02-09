public class AddException extends Exception{
    final int INDEX_NAME = 0;
    final int INDEX_SURNAME = 1;
    final int INDEX_EMAIL = 2;
    final int INDEX_PHONE = 3;
    public AddException(String[] components){
        if(components.length != 4) throw new IllegalArgumentException("Wrong count components");
        if (!components[INDEX_PHONE].matches(".*((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}.*")) throw new IllegalArgumentException("Wrong phone number");
        if (!components[INDEX_EMAIL].matches("[^@]+@[^\\.\\,]+\\..+")) throw new IllegalArgumentException("Wrong email");

    }
}
