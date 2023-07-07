package ru.netology.card.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int addDay) {
        return LocalDate.now().plusDays(addDay).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Абакан", "Архангельск", "Астрахань", "Анадырь", "Барнаул", "Благовещенск",
                "Белгород", "Брянск", "Биробиджан", "Владикавказ", "Владивосток", "Владимимр", "Волгоград", "Вологда",
                "Воронеж", "Великий Новгород", "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново", "Иркутск",
                "Ижевск", "Йошкар-Ола", "Казань", "Кызыл", "Краснодар", "Красноярск", "Калининград", "Калуга",
                "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Липецк", "Москва", "Майкоп", "Махачкала",
                "Магас", "Магадан", "Мурманск", "Нальчик", "Нижний Новгород", "Новосибирск", "Нарьян-Мар", "Орёл",
                "Омск", "Оренбург", "Петрозаводск", "Пенза", "Петропавловск-Комчатский", "Пермь", "Псков", "Рязань",
                "Ростов-на-Дону", "Саранск", "Ставрополь", "Санкт-Петербург", "Салехард", "Самара", "Саратов",
                "Смоленск", "Севастополь", "Симферополь", "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень",
                "Уфа", "Улан-Удэ", "Ульяновск", "Хабаровск", "Ханты-Мансийск", "Чебоксары", "Челябинск", "Черкесск",
                "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
