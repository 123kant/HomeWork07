package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Образец предложения:");
        //String mainSentence = "it cannot be, made larger. it cannot be, made smaller. you cannot change one, of the characters inside it.";
        String mainSentence = getFromFile();

        System.out.println(mainSentence);
        System.out.println("1. Разбить текст по словам:");
        String[] splitWords = splitToWords(mainSentence);
        System.out.println(Arrays.toString(splitWords));

        System.out.println("2. Привести первую букву первого слова текста в заглавную:");
        String[] firstWord = firstWordToUpperCase(mainSentence);
        System.out.println(String.join(" ", firstWord));

        System.out.println("3. Каждое слово после точки начинаться с заглавной буквы:");
        String[] wordsAfterDot = eachWordAfterDotToUpperCase(firstWord);
        System.out.println(Arrays.toString(wordsAfterDot));

        System.out.println("4. Результат:");
        System.out.println(String.join(" ", wordsAfterDot));

        saveToFile(wordsAfterDot);

    }

    public static String[] splitToWords(String sentence) {
        String[] newWordsArr1 = sentence.split("\\W+");
        for (int i = 0; i < newWordsArr1.length; i++) {
        }
        return newWordsArr1;
    }

    public static String[] firstWordToUpperCase(String sentence) {
        String[] newWordsArr2 = sentence.split(" ");
        String firstWord = newWordsArr2[0];
        newWordsArr2[0] = firstWord.substring(0, 1).toUpperCase() + firstWord.substring(1);
        return newWordsArr2;
    }

    public static String[] eachWordAfterDotToUpperCase(String[] firstWord) {
        String[] newWordsArr3 = Arrays.copyOf(firstWord, firstWord.length);
        for (int i = 0; i < newWordsArr3.length; i++) {
            if (newWordsArr3[i].endsWith(".") && i + 1 < newWordsArr3.length) {
                String firstWordAfterDot = newWordsArr3[i + 1];
                newWordsArr3[i + 1] = firstWordAfterDot.substring(0, 1).toUpperCase() + firstWordAfterDot.substring(1);
            }
        }
        return newWordsArr3;
    }

    public static String getFromFile() throws IOException {
        FileReader reader = new FileReader("attachments/InputText.txt");
        Scanner scanner = new Scanner(reader);
        String a = scanner.nextLine();
        reader.close();
        return a;
    }

    public static void saveToFile(String[] wordsAfterDot) throws IOException {
        FileWriter writer = new FileWriter("attachments/OutPut.txt");
        writer.write(String.join(" ", wordsAfterDot));
        writer.close();
    }
}
