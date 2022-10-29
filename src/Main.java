public class Main {
    public static void main(String[] args) {
        // создаем базовый набор корректных записей 1-4
        Record r1 = new Record(1, "1","Masha");
        Record r2 = new Record(2, "2","Max");
        Record r3 = new Record(3, "3","Poly");
        Record r4 = new Record(4, "4","Molly");

        PhoneBook phoneB = new PhoneBook();

        phoneB.createRecord(r1);
        phoneB.createRecord(r2);
        phoneB.createRecord(r3);
        phoneB.createRecord(r4);

        System.out.println(phoneB.getAllRecords()); // [Record@568db2f2, Record@378bf509, Record@5fd0d5ae, Record@2d98a335]

        Record r5 = new Record(1, "5",null); // некорректный ввод имени (пустое)
        Record r6 = new Record(7, "7","Nula"); // некорректный ввод id для изменения записи (7 не существует)
        phoneB.updateRecord(r5); // RecordNotValid
        phoneB.updateRecord(r6); // RecordNotFound

        Record r7 = new Record(1, "5","Mary");
        phoneB.updateRecord(r7);
        System.out.println(phoneB.getAllRecords()); // [Record@27d6c5e0, Record@378bf509, Record@5fd0d5ae, Record@2d98a335]

        phoneB.deleteRecord(7); // RecordNotFound (id=7 не существует)

        phoneB.deleteRecord(1);
        System.out.println(phoneB.getAllRecords()); // [Record@378bf509, Record@5fd0d5ae, Record@2d98a335]

    }
}