public class PhysicalPerson extends Client {

    public PhysicalPerson(){
        setMoneyAmount(0);
    }

    @Override
    public void info() {
        System.out.println("Информация о счете:");
        System.out.println("Текущий баланс: " + super.getAmount());
        System.out.println("Условия снятия: без комиссии.");
        System.out.println("Условия пополнения: без комиссии.");
    }
}
