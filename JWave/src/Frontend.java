import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Frontend {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(createMainPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static JPanel createMainPanel() {
        JPanel panel = new JPanel();

        JTextArea a = new JTextArea();
        panel.add(a);

        JButton b = new JButton();
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playFile(a.getText());
            }
        });
        panel.add(b);

        return panel;
    }

    public static void playFile(String path) {
        File f = new File(path);
        Wave song = null;
        try {
            song = new Wave(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        song.decompress();
        try {
            song.playWave();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}