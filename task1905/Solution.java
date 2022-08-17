package task1905;

import java.util.*;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };

        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+380(50)123-4567";
            }
        };

        DataAdapter dataAdapter = new DataAdapter(customer, contact);
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getDialString());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryName = customer.getCountryName();
            Optional<String> countryCode = countries.entrySet()
                    .stream()
                    .filter(x -> x.getValue().equals(countryName))
                    .map(Map.Entry::getKey)
                    .findFirst();
            return countryCode.orElse("Некорректный код страны");
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            //For example: Ivanov, Ivan
            //For example: Ivan
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            //For example: Ivanov, Ivan
            //For example: Ivanov
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            //For example: +38(050)123-45-67
            //For example: callto://+380501234567
            return "callto://" + contact.getPhoneNumber().replaceAll("[()-]", "");
        }
    }

    public interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}