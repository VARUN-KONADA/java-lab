import java.io.*;

public class FileDemo {
    public static void main(String[] args) {

        // -------------------------------
        // 1. FileInputStream and FileOutputStream
        // -------------------------------

        try {
            FileInputStream input = new FileInputStream("input.txt");
            FileOutputStream output = new FileOutputStream("output.txt");

            int data;

            while ((data = input.read()) != -1) {
                output.write(data);
            }

            input.close();
            output.close();

            System.out.println("Data copied using FileInputStream and FileOutputStream.");
        }
        catch (IOException e) {
            System.out.println(e);
        }


        // -------------------------------
        // 2. FileReader and FileWriter
        // -------------------------------

        try {
            FileReader reader = new FileReader("input.txt");
            FileWriter writer = new FileWriter("output_reader.txt");

            int data;

            while ((data = reader.read()) != -1) {
                writer.write(data);
            }

            reader.close();
            writer.close();

            System.out.println("Data copied using FileReader and FileWriter.");
        }
        catch (IOException e) {
            System.out.println(e);
        }


        // -------------------------------
        // 3. SequenceInputStream
        // -------------------------------

        try {
            FileInputStream input1 = new FileInputStream("input1.txt");
            FileInputStream input2 = new FileInputStream("input2.txt");

            SequenceInputStream sequence =
                    new SequenceInputStream(input1, input2);

            FileOutputStream output =
                    new FileOutputStream("combined.txt");

            int data;

            while ((data = sequence.read()) != -1) {
                output.write(data);
            }

            sequence.close();
            output.close();

            System.out.println("Files combined using SequenceInputStream.");
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}