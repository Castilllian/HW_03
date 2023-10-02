import java.io.FileWriter;
import java.io.IOException;


public class UserInformationApp {
    public static void main(String[] args) {
        try {
            String userInput = "Иванов Иван Иванович 01.01.1990 1234567890 m";
            String[] data = userInput.split(" ");

            if (data.length != 6) {
                throw new Exception("Введено неверное количество данных!");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String dateOfBirth = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (gender != 'f' && gender != 'm') {
                throw new Exception("Неверно указан пол!");
            }

            FileWriter fileWriter = new FileWriter(lastName + ".txt", true);

            String formattedData = lastName + firstName + middleName + dateOfBirth + " " + phoneNumber + gender;
            fileWriter.write(formattedData + System.lineSeparator());

            fileWriter.close();

            System.out.println("Данные успешно сохранены в файл " + lastName + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

