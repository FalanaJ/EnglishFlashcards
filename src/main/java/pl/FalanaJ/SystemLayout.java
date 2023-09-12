package pl.FalanaJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;

public class SystemLayout {
    static JFrame frame = new JFrame("Flashcards Game 1.3");
    static JPanel gamePanel = new JPanel();
    static JPanel displayWordToGuessPanel = new JPanel();
    static Map<String, String> fiszki = new LinkedHashMap<>();
    static Map<String, String> fiszkiForRestart = new LinkedHashMap<>();
    static final JLabel InfoWithWordToWrite = new JLabel("[Tu będzie podane słowo do napisania po angielsku]");
    static final JButton SubmitButton = new JButton("Zatwierdź odpowiedź!");
    public static final TextField GuessPlace = new TextField("");
    public static final JLabel InfoAfterButtonClick = new JLabel("[Tutaj sprawdzamy twoją odpowiedź]");
    static final JButton StartButton = new JButton("Rozpocznij");
    public static final JLabel InfoAfterAllWords = new JLabel("[W tym miejscu poznasz końcowy wynik]");
    static final JButton ExitButton = new JButton("Zakończ");
    static int score = 0;
    static int wordsCounter = 0;
    static int wordsNumber = 1;
    public static void main(String[] args) throws IOException {
        GameLogic gameLogic = new GameLogic();

        try {
            BufferedReader bufferedReaderFile = new BufferedReader(new FileReader("MyEnglishWords.txt"));
            gameLogic.loadWordsFromFile(bufferedReaderFile);
        } catch (FileNotFoundException e){
            ViewController.fileNotFound();
        }

        ViewController.setAppView();
        GuessPlace.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) gameLogic.submitButtonClick();
            }
            public void keyReleased(KeyEvent e) {}
        });

        StartButton.addActionListener(e -> gameLogic.startButtonClick());
        SubmitButton.addActionListener(e -> gameLogic.submitButtonClick());
        ExitButton.addActionListener(e -> System.exit(0));
        gameLogic.closeFunctions();
    }
}
