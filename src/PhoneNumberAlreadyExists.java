public class PhoneNumberAlreadyExists extends Exception {
    public PhoneNumberAlreadyExists() {
        super("Такой номер уже существует");
    }
}
