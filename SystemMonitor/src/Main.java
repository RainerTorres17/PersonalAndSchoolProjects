import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            DirectoryProcessor processor = new DirectoryProcessor();
            FileHandler fileHandler = new FileHandler();

            System.out.println("Welcome to the file handling tool!");
            System.out.println("Enter 'help' to see a list of available commands.");

            while (true) {
                System.out.print("> ");
                String command = scanner.nextLine().trim();
                String[] tokens = command.split(" ");

                if (tokens[0].equals("list")) {
                    if (tokens.length == 2) {
                        String directoryPath = tokens[1];
                        processor.listDirectoryContents(directoryPath);
                    } else {
                        System.out.println("Invalid command. Usage: list <directory>");
                    }
                } else if (tokens[0].equals("move")) {
                    if (tokens.length == 3) {
                        String sourceFilePath = tokens[1];
                        String targetDirectoryPath = tokens[2];
                        fileHandler.moveFile(sourceFilePath, targetDirectoryPath);
                    } else {
                        System.out.println("Invalid command. Usage: move <source> <target>");
                    }
                } else if (tokens[0].equals("rename")) {
                    if (tokens.length == 3) {
                        String sourceFilePath = tokens[1];
                        String newFileName = tokens[2];
                        fileHandler.renameFile(sourceFilePath, newFileName);
                    } else {
                        System.out.println("Invalid command. Usage: rename <file> <newname>");
                    }
                } else if (tokens[0].equals("quit")) {
                    System.out.println("Exiting...");
                    break;
                } else if (tokens[0].equals("help")) {
                    System.out.println("Available commands:");
                    System.out.println("list <directory> - list the contents of a directory");
                    System.out.println("move <source> <target> - move a file to a different directory");
                    System.out.println("rename <file> <newname> - rename a file");
                    System.out.println("quit - exit the program");
                } else {
                    System.out.println("Invalid command. Enter 'help' to see a list of available commands.");
                }
            }
        }
    }
}
