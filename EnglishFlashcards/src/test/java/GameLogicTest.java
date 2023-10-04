import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.FalanaJ.GameLogic;

import static org.junit.jupiter.api.Assertions.*;
import static pl.FalanaJ.Main.*;

public class GameLogicTest {

    private GameLogic gameLogic;

    @BeforeEach
    public void setUp(){
        gameLogic = new GameLogic();
    }

    @Test
    public void testWordsCounterSystem(){
        String englishWord = "CORRECTWORD";
        String polishWord = "polishWord";
        GuessPlace.setText("CorrectWord");
        gameLogic.checkPlayerAnswer(englishWord, polishWord);

        assertEquals(1, gameLogic.getWordsCounter());
        assertNotEquals(0, gameLogic.getWordsCounter());

        System.out.println("if englishWord == text in GuessPlace, action: wordsCounter++");
    }

    @Test
    public void testScoreSystemPass(){
        String englishWord = "CORRECTWORD";
        String polishWord = "polishWord";
        GuessPlace.setText("CorrectWord");
        gameLogic.checkPlayerAnswer(englishWord, polishWord);

        assertEquals(1, gameLogic.getScore());

        System.out.println("if englishWord == text in GuessPlace, action: score = 1");
    }

    @Test
    public void testScoreSystemFail(){
        String englishWord = "CORRECTWORD";
        String polishWord = "polishWord";
        GuessPlace.setText("NOTCorrectWord");
        gameLogic.checkPlayerAnswer(englishWord, polishWord);

        assertEquals(0, gameLogic.getScore());

        System.out.println("if englishWord == text in GuessPlace, action: score = 0");
    }

    @Test
    public void totalScoreInfoTest1(){
        int score = 5;
        int wordsCounter = 5;

        gameLogic.getCorrectInfo(score, wordsCounter);
        assertEquals("GRATULACJE Twój wynik to: 5/5", InfoAfterAllWords.getText());

        System.out.println("When score == wordsCounter, action: Twój wynik to: 5/5");
    }

    @Test
    public void totalScoreInfoTest2(){
        int score = 3;
        int wordsCounter = 6;

        gameLogic.getCorrectInfo(score, wordsCounter);
        assertEquals("Twój wynik to: 3/6", InfoAfterAllWords.getText());

        System.out.println("When score != wordsCounter, action: Twój wynik to: 3/6");
    }



}
