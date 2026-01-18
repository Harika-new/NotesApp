package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotesAppFileOperations {
    static String FILE_NAME = "notes.txt";

    // 1. Create file
    public static void createFile() throws IOException {
        File file = new File(FILE_NAME);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    // 2. Write notes (overwrite)
    public static void writeNotes(List<String> notes) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME);
        for (String note : notes) {
            fw.write(note + "\n");
        }
        fw.close();
        System.out.println("Notes written successfully.");
    }

    // 3. Read notes
    public static void readNotes() throws FileNotFoundException {
        File file = new File(FILE_NAME);
        Scanner sc = new Scanner(file);
        System.out.println("Reading notes:");
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
    }

    // 4. Append note
    public static void appendNote(String note) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(note + "\n");
        fw.close();
        System.out.println("Note appended.");
    }

    // 5. Rename file
    public static void renameFile(String newName) {
        File oldFile = new File(FILE_NAME);
        File newFile = new File(newName);
        if (oldFile.renameTo(newFile)) {
            FILE_NAME = newName; // update name
            System.out.println("File renamed to: " + newName);
        } else {
            System.out.println("Rename failed.");
        }
    }

    // 6. Copy file
    public static void copyFile(String source, String target) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(target);

        int data;
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }

        fis.close();
        fos.close();
        System.out.println("File copied to: " + target);
    }

    // 7. Delete file
    public static void deleteFile(String name) {
        File file = new File(name);
        if (file.delete()) {
            System.out.println("File deleted: " + name);
        } else {
            System.out.println("Delete failed.");
        }
    }

    public static void main(String[] args) {
        try {
            // Step 1: Create file
            createFile();

            // Step 2: Write notes
            List<String> notes = new ArrayList<>();
            notes.add("Today I learned Java file handling.");
            notes.add("File operations are easy.");
            writeNotes(notes);

            // Step 3: Read notes
            readNotes();

            // Step 4: Append note
            appendNote("Practice daily.");
            readNotes();

            // Step 5: Rename file
            renameFile("my_notes.txt");

            // Step 6: Copy file
            copyFile("my_notes.txt", "backup_notes.txt");

            // Step 7: Delete backup
            deleteFile("backup_notes.txt");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
