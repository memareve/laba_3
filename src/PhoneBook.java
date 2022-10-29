import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    protected ArrayList<Record> records = new ArrayList<>();

    public List<Record> getAllRecords() {
        return new ArrayList<>(records);
    }

        public void createRecord(Record record) {
        try {
            if (records.contains(record)) {
                throw new PhoneNumberAlreadyExists();
            }
            else {
                records.add(record);
            }
        }
        catch (PhoneNumberAlreadyExists e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateRecord(Record record) {
        try {
            int i = 0;
            for (Record record1 : records) {
                if (record1.id == record.id) {
                    i++;
                    if (record.name != null && record.phoneNumber != null) {
                        records.set(records.indexOf(record1), record);
                        break;
                    }
                    else {
                        throw new RecordNotValid();
                    }
                }
            }
            if (i == 0) {
                throw new RecordNotFound();
            }
        }
        catch (RecordNotValid | RecordNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteRecord(long id) {
        try {
            for (Record record1 : records) {
                if (record1.id == id) {
                    records.remove(record1);
                    break;
                }
                throw new RecordNotFound();
            }
        }
        catch (RecordNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}






