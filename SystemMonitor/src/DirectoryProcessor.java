import java.io.File;
import java.util.ArrayList;

public class DirectoryProcessor {

    public DirectoryProcessor(){
    }

    public ArrayList<File> listFiles(String directoryName) {

        File directory = new File(directoryName);

        ArrayList<File> files = new ArrayList<File>();
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }

    public ArrayList<File> listDirectories(String directoryName) {

        File directory = new File(directoryName);

        ArrayList<File> directories = new ArrayList<File>();
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                directories.add(file);
            }
        }
        return directories;
    }

    public void listDirectoryContents(String directoryName) {

        File directory = new File(directoryName);

        for (File file : directory.listFiles()) {
            System.out.println(file.getName());
        }
        // Code to list the contents of a directory goes here
    }
}