/*Write a Java program to read data from an input file using FileInputStream
and FileReader, and write data to an output file using FileOutputStream and
FileWriter.  Demonstrate the usage of SequenceInputStream to concatenate
multiple input streams into a single input stream.*/

import java.io.*;

public class Copy
{
    public static void main(String args[]) throws IOException
    {
        int ch;
        FileInputStream fis1 = new FileInputStream("txt1.txt");
        FileInputStream fis2 = new FileInputStream("txt2.txt");
        SequenceInputStream sis = new SequenceInputStream(fis1,fis2);
        // combined input streams from file1 and file2

        FileOutputStream fos = new FileOutputStream("op.txt");

        while((ch = sis.read()) != -1)
        {
            fos.write(ch);
        }

        

        fis1.close();
        fis2.close();
        sis.close();
        fos.close();
    }
}

/* expected output in op.txt
text from txt1
text from txt2
*/

/* actual output in op.txt
text from txt1
text from txt2
*/