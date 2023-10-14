import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int selectOption = JOptionPane.showOptionDialog(null, "Choose Your Playing Level:","Memory Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"12 Cards", "24 Cards"}, "24 Cards");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PictureMemoryGame().setVisible(true);
            }
        });
    }
}
