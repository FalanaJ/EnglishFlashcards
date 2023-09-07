package pl.FalanaJ;

import java.awt.*;

import static pl.FalanaJ.SystemLayout.*;

public class ViewController {
    public static void setAppView(){

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
    }
}
