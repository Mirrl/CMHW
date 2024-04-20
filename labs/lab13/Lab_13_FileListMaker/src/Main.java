import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    private static ArrayList<String> list = new ArrayList<String>();
    private static boolean isModified = false;

    private static char promptChoiceMenu(Scanner pipe) {
        char choice = ' ';

        while (choice == ' ') {
            System.out.println("Select an option from the menu below:");
            System.out.println("A - Add an item to the list");
            System.out.println("D - Delete an item from the list");
            System.out.println("V - View the list");
            System.out.println("C - Clear the list");
            System.out.println("O - Open a list from disk");
            System.out.println("S - Save the list to disk");
            System.out.println("Q - Quit the program");

            String in = SafeInput.getRegExString(pipe, "Enter your choice", "[ADVCOSQadvcosq]");

            if (in.length() > 0) {
                choice = in.toUpperCase().charAt(0);
            }
        }

        return choice;
    }

    private static void addItem(Scanner pipe) {
        String item = SafeInput.getRegExString(pipe, "Enter an item to add to the list", ".*");
        list.add(item);
        isModified = true;
    }

    private static void deleteItem(Scanner pipe) {
        viewList();
        int index = SafeInput.getRangedInt(pipe, "Enter the index of the item you want to delete", 0, list.size() - 1);
        list.remove(index);
        if (pipe.hasNextLine()) pipe.nextLine();
        isModified = true;
    }

    private static void viewList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("[" + i + "]" + " - " + list.get(i));
        }
    }

    private static void clearList() {
        list.clear();
        isModified = true;
    }

    private static String promptFileChoice() {
        String choice = "";

        JFileChooser chooser = new JFileChooser();

        // Set the current directory to the src folder
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        chooser.addChoosableFileFilter(filter);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            choice = chooser.getSelectedFile().toPath().toString();
            if (!choice.endsWith(".txt")) {
                choice += ".txt";
            }
        }

        return choice;
    }

    private static ArrayList<String> readFile(String filePath) {
        ArrayList<String> lines = new ArrayList<String>();
        // read the file
        try {
            Path file = new File(filePath).toPath();
            InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
        } catch (IOException e) {
            System.out.println("Something went wrong reading the file!");
        }

        return lines;
    }

    private static boolean promptSaveList() {
        String filePath = promptFileChoice();
        if (filePath.isEmpty()) {
            System.out.println("File not found... aborting!");
            return false;
        }

        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(new File(filePath));
            for (String item : list) {
                writer.println(item);
            }
            writer.close();

            isModified = false; // File was just saved memory is identical to disk

            return true;
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
            return false;
        }
    }

    private static boolean promptSafetySave(Scanner pipe) {
        if (!list.isEmpty() && isModified) {
            if (!SafeInput.getYNConfirm(pipe, "Warning! There are unsaved changes!\nDo you want to save the current list? (Y/N)")) {
                return true;
            }

            return promptSaveList();
        }

        return true;
    }

    private static void promptLoadListFromDisk(Scanner pipe) {
        if (!promptSafetySave(pipe)) {
            System.out.println("Something went wrong trying to save the file... aborting, please try again");
            return;
        }

        String filePath = promptFileChoice();
        list = readFile(filePath);

        isModified = false; // File was just loaded memory is identical to disk
    }

    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);

        char choice = ' ';
        while (choice != 'Q') {
            choice = promptChoiceMenu(pipe);

            switch (choice) {
                case 'A':
                    addItem(pipe);
                    break;
                case 'D':
                    deleteItem(pipe);
                    break;
                case 'V':
                    viewList();
                    break;
                case 'C':
                    clearList();
                    break;
                case 'Q':
                    if (promptSafetySave(pipe)) {
                        if (!SafeInput.getYNConfirm(pipe, "Are you sure you want to quit? (Y/N)")) {
                            choice = ' ';
                        }
                    }
                    break;
                case 'O':
                    promptLoadListFromDisk(pipe);
                    break;
                case 'S':
                    if (SafeInput.getYNConfirm(pipe, "Are you sure you want to save the list? (Y/N)")) {
                        if (!promptSaveList()) {
                            System.out.println("Something went wrong, the list could not be saved... please try again!");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid option (" + choice + ")");
                    break;
            }
        }
    }
}
