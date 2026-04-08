import java.util.*;

public class Week3_4 {

    static class Client {
        String name;
        int riskScore;
        double balance;

        Client(String name, int riskScore, double balance) {
            this.name = name;
            this.riskScore = riskScore;
            this.balance = balance;
        }
    }

    static void bubbleSort(Client[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Swaps: " + swaps);
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].balance < key.balance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    static void display(Client[] arr) {
        for (Client c : arr) {
            System.out.println(c.name + " : " + c.riskScore);
        }
    }

    public static void main(String[] args) {

        Client[] arr = {
                new Client("C", 80, 2000),
                new Client("A", 20, 5000),
                new Client("B", 50, 3000)
        };

        System.out.println("Bubble Sort (Ascending):");
        bubbleSort(arr);
        display(arr);

        System.out.println("\nInsertion Sort (Descending):");
        insertionSort(arr);
        display(arr);

        System.out.println("\nTop 3 Highest Risk:");
        for (int i = 0; i < Math.min(3, arr.length); i++) {
            System.out.println(arr[i].name + " (" + arr[i].riskScore + ")");
        }
    }
}