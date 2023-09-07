package pl.FalanaJ;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Layout {
    static JFrame frame = new JFrame("Flashcards Game 1.0");
    static JPanel gamePanel = new JPanel();
    static JPanel displayWordToGuessPanel = new JPanel();
    static Map<String, String> fiszki = new LinkedHashMap<>();
    private static final JLabel InfoWithWordToWrite = new JLabel("[Tu będzie podane słowo do napisania po angielsku]");
    private static final JButton SubmitButton = new JButton("Zatwierdź odpowiedź!");
    private static final TextField GuessPlace = new TextField("");
    private static final JLabel InfoAfterButtonClick = new JLabel("[Tutaj sprawdzamy twoją odpowiedź]");
    private static final JButton StartButton = new JButton("Naciśnij aby rozpocząć!");
    private static final JLabel InfoAfterAllWords = new JLabel("[W tym miejscu poznasz końcowy wynik]");
    static int score = 0;
    static int wordsNumber = 0;

    public static void main(String[] args) throws IOException {

        frame.setSize(700, 350);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        Color gamePanelColor = new Color(0x2DA6A1);
        Color displayWordToGuessPanelColor = new Color(0x048884);

        gamePanel.setBackground(gamePanelColor);
        gamePanel.setPreferredSize(new Dimension(700, 350));

        displayWordToGuessPanel.setBackground(displayWordToGuessPanelColor);
        gamePanel.add(displayWordToGuessPanel);
        displayWordToGuessPanel.add(InfoWithWordToWrite);
        InfoWithWordToWrite.setPreferredSize(new Dimension(550, 50));
        InfoWithWordToWrite.setFont(new Font("Arial", Font.BOLD, 20));

        gamePanel.add(GuessPlace);
        GuessPlace.setPreferredSize(new Dimension(550, 30));
        GuessPlace.setFont(new Font("Arial", Font.PLAIN, 20));

        gamePanel.add(SubmitButton);
        SubmitButton.setPreferredSize(new Dimension(300, 50));
        SubmitButton.setEnabled(false);
        SubmitButton.setFont(new Font("Arial", Font.PLAIN, 20));

        gamePanel.add(StartButton);
        StartButton.setPreferredSize(new Dimension(300, 50));
        StartButton.setFont(new Font("Arial", Font.PLAIN, 20));

        gamePanel.add(InfoAfterButtonClick);
        InfoAfterButtonClick.setPreferredSize(new Dimension(550, 25));
        InfoAfterButtonClick.setFont(new Font("Arial", Font.BOLD, 20));

        gamePanel.add(InfoAfterAllWords);
        InfoAfterAllWords.setPreferredSize(new Dimension(550, 25));
        InfoAfterAllWords.setFont(new Font("Arial", Font.BOLD, 20));


        BufferedReader bufferedReaderAnswer = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader("MyEnglishWords.txt"));

        String line;
        while ((line = bufferedReaderFile.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();

                fiszki.put(key, value);
            }
        }

        StartButton.addActionListener(e -> {
            SubmitButton.setEnabled(true);

            String firstKey = fiszki.keySet().iterator().next();
            InfoWithWordToWrite.setText(firstKey);
            InfoAfterAllWords.setText("");
            InfoAfterButtonClick.setText("");
            StartButton.setEnabled(false);
        });

        SubmitButton.addActionListener(e -> {
            Map.Entry<String, String> entry = fiszki.entrySet().iterator().next();
            String polishWord = entry.getKey();
            String englishWord = entry.getValue();

            InfoWithWordToWrite.setText(polishWord);
            String answer = GuessPlace.getText().toUpperCase();

            if(answer.equals(englishWord)){
                InfoAfterButtonClick.setText("Zgadza się!");
                score++;
                wordsNumber++;
            }
            else{
                InfoAfterButtonClick.setText("Niestety to nie to słowo.. Odpowiedź to: " + englishWord);
                wordsNumber++;
            }

            fiszki.remove(polishWord);


            if (!fiszki.isEmpty()) {
                Map.Entry<String, String> nextEntry = fiszki.entrySet().iterator().next();
                String nextPolishWord = nextEntry.getKey();

                InfoWithWordToWrite.setText(nextPolishWord);
                GuessPlace.setText("");
            } else {
                InfoWithWordToWrite.setText("To już wszystkie słowa!");
                GuessPlace.setEnabled(false);
                SubmitButton.setEnabled(false);

                if(score == wordsNumber) InfoAfterAllWords.setText("GRATULACJE Twój wynik to: " + score + "/" + wordsNumber);
                else InfoAfterAllWords.setText("Twój wynik to: " + score + "/" + wordsNumber);
            }
        });

        bufferedReaderFile.close();
        bufferedReaderAnswer.close();
        frame.add(gamePanel);
        frame.setVisible(true);
    }
}


//TODO dodaj opcję by zatwierdzać odpowiedź enterem
//TODO porozdzielaj i posprzątaj kod dla czytelności
//TODO dodaj to by wyrazenia w InfoAfterButtonClick się zmieniały
//TODO przycisk reset i zakończ (reset to moze byc StartButton po zakonczeniu gry)
//TODO co gdy program nie znajdzie pliku ze słówkami