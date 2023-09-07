package pl.FalanaJ;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class SystemLayout {
    static JFrame frame = new JFrame("Flashcards Game 1.1");
    static JPanel gamePanel = new JPanel();
    static JPanel displayWordToGuessPanel = new JPanel();
    static Map<String, String> fiszki = new LinkedHashMap<>();
    static final JLabel InfoWithWordToWrite = new JLabel("[Tu będzie podane słowo do napisania po angielsku]");
    static final JButton SubmitButton = new JButton("Zatwierdź odpowiedź!");
    static final TextField GuessPlace = new TextField("");
    static final JLabel InfoAfterButtonClick = new JLabel("[Tutaj sprawdzamy twoją odpowiedź]");
    static final JButton StartButton = new JButton("Naciśnij aby rozpocząć!");
    static final JLabel InfoAfterAllWords = new JLabel("[W tym miejscu poznasz końcowy wynik]");
    static int score = 0;
    static int wordsNumber = 0;
    public static void main(String[] args) throws IOException {
        GameLogic gameLogic = new GameLogic();

        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader("MyEnglishWords.txt"));
        ViewController.setAppView();
        gameLogic.loadWordsFromFile(bufferedReaderFile);
        StartButton.addActionListener(e -> gameLogic.startButtonMethods());
        SubmitButton.addActionListener(e -> gameLogic.submitButtonMethods());
        bufferedReaderFile.close();
        gameLogic.closeMethods();
    }
}


//TODO dodaj opcję by zatwierdzać odpowiedź enterem
//TODO przycisk reset i zakończ (reset to moze byc StartButton po zakonczeniu gry)
//TODO co gdy program nie znajdzie pliku ze słówkami