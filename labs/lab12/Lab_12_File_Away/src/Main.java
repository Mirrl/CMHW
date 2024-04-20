import javax.swing.*;
import java.io.*;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.lang.System.in;
import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static void main(String[] args) {
      JFileChooser chooser = new JFileChooser();

      // Set the current directory to the src folder
      Path target = new File(System.getProperty("user.dir")).toPath();
      target = target.resolve("src");
      chooser.setCurrentDirectory(target.toFile());

      try {
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          target = chooser.getSelectedFile().toPath();

          System.out.println("Opening file: " + target.getFileName());

          int lineCount = 0;
          int wordCount = 0;
          int characterCount = 0;

          // Read the file line by line
          InputStream in = new BufferedInputStream(Files.newInputStream(target, CREATE));
          BufferedReader reader = new BufferedReader(new InputStreamReader(in));
          while (reader.ready()) {
            lineCount++;

            String line = reader.readLine();

            characterCount += line.length();

            wordCount += line.split(" ").length;
          }

          reader.close();

          System.out.println("Lines: " + lineCount + "\nWords: " + wordCount + "\nCharacters: " + characterCount);
        } else {
          System.out.println("No file was selected.");
          System.exit(0);
        }
      }
      catch (FileNotFoundException e) {
        System.out.println("File not found.");
        e.printStackTrace();
      }
      catch (IOException e) {
        System.out.println("An error occurred while reading the file.");
        e.printStackTrace();
      }
    }
}
