package main;

import Model.MySnake;
import Support.Common;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author thanhtri
 */
public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Slither.io");
        setContentPane(new InnerGame(Common.INSTANCE.room.getPlayerNameList().indexOf(Common.INSTANCE.g_PlayerName)));
        //add(new InnerGame(Common.INSTANCE.room.getPlayerNameList().indexOf(Common.INSTANCE.g_PlayerName)));
        pack();
        setDefaultCloseOperation(3); // 3: EXIT_ON_CLOSE
        setResizable(false);
        setBounds(0, 0, InnerGame.WIDTH + 5, InnerGame.HEIGHT - 5);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}