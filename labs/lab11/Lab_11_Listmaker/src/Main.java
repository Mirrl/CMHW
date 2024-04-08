import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static ArrayList<String> list = new ArrayList<String>();

  private static char promptChoiceMenu(Scanner pipe) {
    char choice = ' ';

    while (choice == ' ') {
      System.out.println("Select an option from the menu below:");
      System.out.println("A - Add an item to the list");
      System.out.println("D - Delete an item from the list");
      System.out.println("P - Print the list");
      System.out.println("Q - Quit the program");

      String in = SafeInput.getRegExString(pipe, "Enter your choice", "[ADPQadpq]");

      if (in.length() > 0) {
        choice = in.toUpperCase().charAt(0);
      }
    }

    return choice;
  }

  private static void addItem(Scanner pipe) {
    String item = SafeInput.getRegExString(pipe, "Enter an item to add to the list", ".*");
    list.add(item);
  }

  private static void deleteItem(Scanner pipe) {
    printList();
    int index = SafeInput.getRangedInt(pipe, "Enter the index of the item you want to delete", 0, list.size() - 1);
    list.remove(index);
    if (pipe.hasNextLine())
      pipe.nextLine();
  }

  private static void printList() {
    if (list.isEmpty()) {

    }
    for (int i = 0; i < list.size(); i++) {
      System.out.println("[" + i + "]" + " - " + list.get(i));
    }
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
        case 'P':
          printList();
          break;
        case 'Q':
          if (!SafeInput.getYNConfirm(pipe, "Are you sure you want to quit? (Y/N)")) {
            choice = ' ';
          }
          break;
         default:
           System.out.println("Invalid option (" + choice + ")");
           break;
       }
    }
  }
}
