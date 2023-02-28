import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class sortings {

    static String filePath = System.getProperty("user.dir") + "/ressources/zahlen";
    static String filePathBubble = System.getProperty("user.dir") + "/ressources/zahlenBubble";
    static String filePathSelection = System.getProperty("user.dir") + "/ressources/zahlenSelection";
    static String filePathQuick = System.getProperty("user.dir") + "/ressources/zahlenQuick";
    static String filePathMerge = System.getProperty("user.dir") + "/ressources/zahlenMerge";
    static String filePathHeap = System.getProperty("user.dir") + "/ressources/zahlenHeap";

    public static void main(String[] args) {
        generateNumbers();
        int[] numbers = readNumbers(filePath);

    }


    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Eine Schleife für die Durchgänge des Sortieralgorithmus
        for (int i = 0; i < n - 1; i++) {

            // Finde das Minimum im Array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Tausche das Minimum mit dem aktuellen Element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }


    public void mergeSort() {

    }

    public void quickSort() {

    }

    public void heapSort() {

    }

    public static int[] readNumbers(String filePath) {
        try {
            int[] arr = Files.lines(Paths.get(filePath))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println("Zahlen erfolgreich aus der Datei gelesen.");
            return arr;
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
            return new int[0];
        }
    }

    public static void writeNumbers(String filePath, int[] arr) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int number : arr) {
                writer.write(Integer.toString(number));
                writer.newLine();
            }
            System.out.println("Sortierte Zahlen erfolgreich in die Datei geschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }

    public static void generateNumbers() {
        String filePath = "ressources/zahlen";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            for (int i = 0; i < 30; i++) {
                int number = random.nextInt(100) + 1;
                writer.write(Integer.toString(number));
                writer.newLine();
            }
            System.out.println("30 Zahlen erfolgreich generiert und in die Datei geschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }
}