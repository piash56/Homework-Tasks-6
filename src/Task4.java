
import java.io.File;
import java.util.Scanner;

public class Task4 {

    public static long calculateSize(File directory) {

        long totalSize = 0;

        File[] files = directory.listFiles();

        if (files == null) {
            return 0;
        }

        for (File file : files) {

            if (file.isFile()) {
                totalSize += file.length();
            }

            else if (file.isDirectory()) {
                totalSize += calculateSize(file);
            }
        }

        return totalSize;
    }

    public static void displaySize(long bytes) {

        double kb = bytes / 1024.0;
        double mb = kb / 1024.0;

        System.out.println("Bytes: " + bytes);
        System.out.printf("KB: %.2f%n", kb);
        System.out.printf("MB: %.2f%n", mb);
    }

    public static void showDirectorySizes(File directory) {

        File[] files = directory.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {

            if (file.isDirectory()) {

                long size = calculateSize(file);

                System.out.println();
                System.out.println("Directory: " + file.getName());

                displaySize(size);

                showDirectorySizes(file);
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter directory path: ");

        String path = input.nextLine();

        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {

            System.out.println("Error: Directory does not exist.");

        } else {

            long totalSize = calculateSize(directory);

            System.out.println();
            System.out.println("Directory: " + directory.getName());

            System.out.println("Total directory size:");

            displaySize(totalSize);

            System.out.println();
            System.out.println("Individual directory sizes:");

            showDirectorySizes(directory);
        }

        input.close();
    }
}
