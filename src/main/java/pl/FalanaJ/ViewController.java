package pl.FalanaJ;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static pl.FalanaJ.Main.*;

public class ViewController {
    public static void setAppView(){

        try {
            BufferedImage iconImage = ImageIO.read(new File("images/logo.png"));
            frame.setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        GuessPlace.setEnabled(false);
        GuessPlace.setFont(new Font("Arial", Font.PLAIN, 20));

        gamePanel.add(SubmitButton);
        SubmitButton.setPreferredSize(new Dimension(300, 50));
        SubmitButton.setEnabled(false);
        SubmitButton.setFont(new Font("Arial", Font.PLAIN, 20));

        gamePanel.add(InfoAfterButtonClick);
        InfoAfterButtonClick.setPreferredSize(new Dimension(550, 25));
        InfoAfterButtonClick.setFont(new Font("Arial", Font.BOLD, 20));

        gamePanel.add(InfoAfterAllWords);
        InfoAfterAllWords.setPreferredSize(new Dimension(550, 25));
        InfoAfterAllWords.setFont(new Font("Arial", Font.BOLD, 20));

        gamePanel.add(StartButton);
        StartButton.setPreferredSize(new Dimension(300, 50));
        StartButton.setFont(new Font("Arial", Font.PLAIN, 20));

        gamePanel.add(ExitButton);
        ExitButton.setPreferredSize(new Dimension(300, 50));
        ExitButton.setFont(new Font("Arial", Font.PLAIN, 20));
    }
    public static void fileNotFound(){

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
        InfoWithWordToWrite.setText("PLIK ZE SŁÓWKAMI NIE ZOSTAŁ ZNALEZIONY [!!!]");
        StartButton.setEnabled(false);
    }
}
