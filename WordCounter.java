import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class WordCounter//Task-2 
{

    public static int countWords(String text) 
    {
        String[] words = text.split("[\\s\\p{Punct}]+");
        return words.length;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Please choose an option:");
        System.out.println("1. Enter text manually");
        System.out.println("2. Provide a file");

        int choice = scanner.nextInt();
        scanner.nextLine();
        int totalWords;

        switch (choice) 
	{
            case 1:
                System.out.println("Enter the text:");
                String userText = scanner.nextLine();
                totalWords = countWords(userText);
                System.out.println("Total words in the text: " + totalWords);
                break;
            case 2:
                System.out.println("Enter the file name:");
                String fileName = scanner.nextLine();
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) 
                {
                    StringBuilder fileContent = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) 
                    {
                        fileContent.append(line).append("\n");
                    }
                    totalWords = countWords(fileContent.toString());
                    System.out.println("Total words in the file: " + totalWords);
                } 
                catch (IOException e) 
                {
                    System.out.println("File not found or error reading the file.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please enter either '1' or '2'.");
                break;
        }

        scanner.close();
    }
}
