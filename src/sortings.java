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
        int choice = 0;
        while (choice != 6) {
            printMenu();
            choice = new java.util.Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    bubbleSort(numbers);
                    writeNumbers(filePathBubble, numbers);
                    exportToConsole(numbers);
                    break;
                case 2:
                    selectionSort(numbers);
                    writeNumbers(filePathSelection, numbers);
                    exportToConsole(numbers);
                    break;
                case 3:
                    sortings s = new sortings();
                    s.quickSort(numbers, 0, numbers.length - 1);
                    writeNumbers(filePathQuick, numbers);
                    exportToConsole(numbers);
                    break;
                case 4:
                    mergeSort(numbers);
                    writeNumbers(filePathMerge, numbers);
                    exportToConsole(numbers);
                    break;
                case 5:
                    heapSort(numbers);
                    writeNumbers(filePathHeap, numbers);
                    exportToConsole(numbers);
                    break;
                case 6:
                    System.out.println("Beenden...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bitte wählen Sie eine Sortieralgorithmus aus");
                    break;
            }
        }

    }

    public static void printMenu() {
        System.out.println("Auswahl zwischen mehreren Sortieralgorithmen");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Heap Sort");
        System.out.println("6. Exit");
        System.out.print("Bitte wählen Sie eine Sortieralgorithmus aus: ");
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

    public static void exportToConsole(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
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


    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < nL) {
            arr[k++] = left[i++];
        }
        while (j < nR) {
            arr[k++] = right[j++];
        }
    }


    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
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