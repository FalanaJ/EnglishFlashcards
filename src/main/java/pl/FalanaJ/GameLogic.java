package pl.FalanaJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import static pl.FalanaJ.SystemLayout.*;

public class GameLogic {
    public static void checkPlayerAnswer(String englishWord, String polishWord){
        InfoWithWordToWrite.setText(polishWord);
        String answer = GuessPlace.getText().toUpperCase();
        if(answer.equals(englishWord)){

            List<String> ShowAfterBtnAnswerList = new ArrayList<>
                    (Arrays.asList("Zgadza się!", "Dokładnie tak!", "Poprawna odpowiedź!", "Oczywiście, że tak!"));
            Random random = new Random();

            InfoAfterButtonClick.setText(ShowAfterBtnAnswerList.get(random.nextInt(ShowAfterBtnAnswerList.size())));
            score++;
        }
        else{
            InfoAfterButtonClick.setText("Niestety to nie to słowo.. Odpowiedź to: " + englishWord);
        }
        wordsCounter++;
    }
    public void submitButtonClick(){
        Map.Entry<String, String> entry = fiszki.entrySet().iterator().next();
        String polishWord = entry.getKey();
        String englishWord = entry.getValue();

        checkPlayerAnswer(englishWord, polishWord);
        fiszki.remove(polishWord);

        if (!fiszki.isEmpty()) getNextWord();
        else gameOver();
    }
    public void startButtonClick(){
        SubmitButton.setEnabled(true);
        GuessPlace.setEnabled(true);
        String firstKey = fiszki.keySet().iterator().next();
        InfoWithWordToWrite.setText(wordsNumber + ". " + firstKey);
        InfoAfterAllWords.setText("");
        InfoAfterButtonClick.setText("");
        StartButton.setEnabled(false);
    }
    public void gameOver(){
        InfoWithWordToWrite.setText("To już wszystkie słowa!");
        GuessPlace.setEnabled(false);
        SubmitButton.setEnabled(false);

        if(score == wordsCounter) InfoAfterAllWords.setText("GRATULACJE Twój wynik to: " + score + "/" + wordsCounter);
        else InfoAfterAllWords.setText("Twój wynik to: " + score + "/" + wordsCounter);

        StartButton.setText("Restartuj");
        StartButton.setEnabled(true);
        GuessPlace.setText("");

        fiszki.putAll(fiszkiForRestart);
        StartButton.addActionListener(e -> startButtonClick());
        score = wordsCounter = 0;
        wordsNumber = 1;
    }
    public void getNextWord(){
        Map.Entry<String, String> nextEntry = fiszki.entrySet().iterator().next();
        String nextPolishWord = nextEntry.getKey();

        wordsNumber++;
        InfoWithWordToWrite.setText(wordsNumber + ". " + nextPolishWord);
        GuessPlace.setText("");
    }
    public void closeFunctions(){
        frame.add(gamePanel);
        frame.setVisible(true);
    }
    public void loadWordsFromFile(BufferedReader bufferedReaderFile) throws IOException {
        String line;
        while ((line = bufferedReaderFile.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();

                fiszki.put(key, value);
                fiszkiForRestart.put(key, value);
            }
        }
    }
}
