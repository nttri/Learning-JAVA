/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Support;

import Model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import main.SnakeClient;

/**
 *
 * @author thanhtri
 */
public class Common {
    public JFrame mainFrame = new JFrame();
    public JFrame gameFrame = null;
    public JFrame roomFrame = null;
    public SnakeClient client = null;
    public String g_PlayerName = "tri";
    public Room room;
    public GamePlay gamePlay;
    public int g_Port = 3222;
    public List<String> g_PlayerNameList = new ArrayList<String>();
    public static Common INSTANCE = new Common();

    public void create() {
        Random rand = new Random();
        g_Port = (rand.nextInt(8900) + 1000);
        new ServerService(g_Port).start();
    }
}
