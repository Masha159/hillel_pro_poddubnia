package lesson4.homework;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Customer customer = getCustomer(getData());
            String output = "Customer: " + customer.getName() +
                    ", phone: " + customer.getPhone();
            getOutput(output);
        }

        public static String[] getData() {
            System.out.println("Enter your name: ");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            System.out.println("Enter your phone: ");
            String phone = in.nextLine();
            return new String[]{name, phone};
        }

        public static Customer getCustomer(String[] data) {
            return new Customer(data[0], data[1]);
        }

        public static void getOutput(String output) {
            System.out.println(output);
        }

}
