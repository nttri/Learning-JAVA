/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Support.Common;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author thanhtri
 */
public class InnerGame extends JPanel implements ActionListener{
    private int myIndex = 0;
    // Dimension of the panel
    public static final int WIDTH = 800;
    public static final int HEIGHT = 520;
    // Directions
    private boolean up = false;
    private boolean left = false;
    private boolean right = false;
    private boolean down = false;
    // image config
    private final ImageIcon gFood = new ImageIcon("resource\\Food.png");
    private final ImageIcon aHead = new ImageIcon("resource\\aHead.png");
    private final ImageIcon aBody = new ImageIcon("resource\\abody.png");
    private final ImageIcon bHead = new ImageIcon("resource\\bHead.png");
    private final ImageIcon bBody = new ImageIcon("resource\\bBody.png");
    // Common
    private boolean isGameover = false;
    private Random rand = new Random();
    private int fxp = rand.nextInt(36);
    private int fyp = rand.nextInt(19);
    private final Timer timer;
    private final int delay = 200;
    private boolean needRepaint = true;
    private boolean viewRes = false;

    public InnerGame(int pos) {
        addKeyListener(new TAdapter());
        setFocusable(true);
        myIndex = pos;
        timer = new Timer(delay, this);
        timer.start();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT)) {
                Common.INSTANCE.client.playerMove("goLeft");
                up = true;
                if (!down) {
                    up = true;
                } else {
                    up = false;
                }
                left = right = false;
            }

            if ((key == KeyEvent.VK_RIGHT)) {
                Common.INSTANCE.client.playerMove("goRight");
                up = true;
                if (!down) {
                    up = true;
                } else {
                    up = false;
                }
                left = right = false;
            }

            if ((key == KeyEvent.VK_UP)) {
                Common.INSTANCE.client.playerMove("goUp");
                up = true;
                if (!down) {
                    up = true;
                } else {
                    up = false;
                }
                left = right = false;
            }

            if ((key == KeyEvent.VK_DOWN)) {
                Common.INSTANCE.client.playerMove("goDown");
                up = true;
                if (!down) {
                    up = true;
                } else {
                    up = false;
                }
                left = right = false;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // info area
        g.setColor(new Color(27, 114, 95));
        g.fillRect(0, 0, (WIDTH * 2) / 10, 40);
        g.setColor(new Color(103, 33, 79));
        g.fillRect((WIDTH * 2) / 10, 0, (WIDTH * 8) / 10, 40);

        // draw names + scores
        g.setColor(new Color(51, 217, 178));
        g.setFont(new Font("tahoma", Font.BOLD, 19));
        g.drawString(Common.INSTANCE.g_PlayerNameList.get(myIndex), 10, 17);
        g.drawString(Integer.toString(Common.INSTANCE.gamePlay.getPlayerList().get(myIndex).getSnakeLen() * 10), 10, 37);

        int k = 0;
        for (int i = 0; i < Common.INSTANCE.g_PlayerNameList.size(); i++) {
            if (i != myIndex) {
                g.setColor(new Color(230, 230, 230));
                g.setFont(new Font("tahoma", Font.PLAIN, 18));
                g.drawString(Common.INSTANCE.g_PlayerNameList.get(i), 180 + k*210, 14);
                g.drawString(" " + Common.INSTANCE.gamePlay.getPlayerList().get(i).getSnakeLen() * 10, 180 + k*210, 35);
                k++;
            }
        }

        if (!Common.INSTANCE.gamePlay.getPlayerList().get(myIndex).isPlaying() && !viewRes) {
            needRepaint = false;
            viewRes = true;
            // draw text when game is over
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("tahoma", Font.BOLD, 30));
            g.drawString("Bạn đã THUA!", 340, 460);
            Object[] btnName = {"Back to menu", "Wait for game result"};
            int n = JOptionPane.showOptionDialog(this, "YOU LOSED!", "Choose an option below", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, btnName, btnName[0]);
            if (n == JOptionPane.NO_OPTION) {
                needRepaint = true;
            }
        }

        // play area
        g.setColor(new Color(250, 250, 250));
        g.fillRect(0, 40, WIDTH, HEIGHT - 40);
        //super.paint(g);

        for (int i = 0; i < 3; i++) {
            g.drawImage(gFood.getImage(), Common.INSTANCE.gamePlay.getFoodXPos()[i], Common.INSTANCE.gamePlay.getFoodYPos()[i], this);
        }
        for (int i = 0; i < 4; i++) {
            if (Common.INSTANCE.gamePlay.getPlayerList().get(i).isPlaying()) {
                for (int z = 0; z < Common.INSTANCE.gamePlay.getPlayerList().get(i).getSnakeLen(); z++) {
                    if (z == 0) {
                        if (i - myIndex == 0) {
                            g.drawImage(aHead.getImage(), Common.INSTANCE.gamePlay.getPlayerList().get(i).getxSnake()[z], Common.INSTANCE.gamePlay.getPlayerList().get(i).getySnake()[z], this);
                        } else {
                            g.drawImage(bHead.getImage(), Common.INSTANCE.gamePlay.getPlayerList().get(i).getxSnake()[z], Common.INSTANCE.gamePlay.getPlayerList().get(i).getySnake()[z], this);
                        }
                    } else {
                        if (i - myIndex == 0) {
                            g.drawImage(aBody.getImage(), Common.INSTANCE.gamePlay.getPlayerList().get(i).getxSnake()[z], Common.INSTANCE.gamePlay.getPlayerList().get(i).getySnake()[z], this);
                        } else {
                            g.drawImage(bBody.getImage(), Common.INSTANCE.gamePlay.getPlayerList().get(i).getxSnake()[z], Common.INSTANCE.gamePlay.getPlayerList().get(i).getySnake()[z], this);
                        }
                    }
                }
            }
        }
        //Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (needRepaint) {
            left = right = up = down = false;
            repaint();
        }
    }
}
