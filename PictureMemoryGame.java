import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class PictureMemoryGame extends JFrame {
    private ArrayList<String> imagePaths;
    private ArrayList<String> cardImages;
    private JButton[] cardButtons;
    private int numberOfMatches;
    private int firstCardIndex = -1;
    private int secondCardIndex;
    private int playerMoves;

    public PictureMemoryGame() {
        setTitle("Picture Memory Game");
        setSize(725, 725);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        imagePaths = new ArrayList<>();
        imagePaths.add("Salem1.PNG");
        imagePaths.add("Salem2.PNG");
        imagePaths.add("Salem3.PNG");
        imagePaths.add("Salem4.PNG");
        imagePaths.add("Salem5.PNG");
        imagePaths.add("Salem6.PNG");
        imagePaths.add("Salem7.PNG");
        imagePaths.add("Salem8.PNG");
        imagePaths.add("Salem9.PNG");
        imagePaths.add("Salem10.PNG");
        imagePaths.add("Salem11.PNG");
        imagePaths.add("Salem12.PNG");
        imagePaths.add("Salem1.PNG");
        imagePaths.add("Salem2.PNG");
        imagePaths.add("Salem3.PNG");
        imagePaths.add("Salem4.PNG");
        imagePaths.add("Salem5.PNG");
        imagePaths.add("Salem6.PNG");
        imagePaths.add("Salem7.PNG");
        imagePaths.add("Salem8.PNG");
        imagePaths.add("Salem9.PNG");
        imagePaths.add("Salem10.PNG");
        imagePaths.add("Salem11.PNG");
        imagePaths.add("Salem12.PNG");


        cardImages = new ArrayList<>();
        for (String imagePath : imagePaths) {
            cardImages.add("");

        }
        playerMoves = 0;

        Collections.shuffle(imagePaths);
        Collections.shuffle(cardImages);

        JPanel cardPanel1 = new JPanel(new GridLayout(4, 3));
        cardButtons = new JButton[12];

        JPanel cardPanel2 = new JPanel(new GridLayout(4, 6));
        cardButtons = new JButton[24];

        for (int i = 0; i < cardButtons.length; i++) {
            final int index = i;
            cardButtons[i] = new JButton();
            cardButtons[i].setIcon(new ImageIcon("Cat.PNG"));
            cardButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleCardClick(index);
                }
            });
            cardPanel1.add(cardButtons[i]);
            cardPanel2.add(cardButtons[i]);
        }
        add(cardPanel1);
        add(cardPanel2);
    }

    private void restartGame() {
        numberOfMatches = 0;
        firstCardIndex = -1;
        secondCardIndex = -1;

        cardImages.clear();
        for (int i = 0; i < imagePaths.size(); i++) {
            cardImages.add("");
        }

        Collections.shuffle(imagePaths);
        Collections.shuffle(cardImages);
    }

    private void handleCardClick(int index) {
        if (cardImages.get(index) == null) {
            return;

        }

        playerMoves++;

        if (firstCardIndex == -1) {
            firstCardIndex = index;
            cardButtons[firstCardIndex].setIcon(new ImageIcon(imagePaths.get(index)));

        } else {
            secondCardIndex = index;
            cardButtons[secondCardIndex].setIcon(new ImageIcon(imagePaths.get(index)));



            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (imagePaths.get(firstCardIndex).equals(imagePaths.get(secondCardIndex))) {
                        cardButtons[firstCardIndex].setIcon(new ImageIcon("BlankIcon.PNG"));
                        cardButtons[secondCardIndex].setIcon(new ImageIcon("BlankIcon.PNG"));
                        cardImages.set(firstCardIndex, null);
                        cardImages.set(secondCardIndex, null);
                        numberOfMatches++;
                    }

                    if (numberOfMatches == imagePaths.size() / 2) {
                        JOptionPane.showMessageDialog(null, "Congrats! You Matched All The Salem's.");
                        JOptionPane.showMessageDialog(null, "Number Of Moves During Your Game:" + playerMoves);
                        int restartOption = JOptionPane.showOptionDialog(null, "Would You Like To Restart?","Memory Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Play Again",  "Quit?"}, "Play Again");

                        if (restartOption == 0) {
                            restartGame();

                        }else {
                            System.exit(0);
                        }

                    } else {
                        cardButtons[firstCardIndex].setIcon(new ImageIcon("Cat.PNG"));
                        cardButtons[secondCardIndex].setIcon(new ImageIcon("Cat.PNG"));
                    }
                    firstCardIndex = -1;
                }
            });
            timer.setRepeats(false);
            timer.start(); //
        }
    }
}
