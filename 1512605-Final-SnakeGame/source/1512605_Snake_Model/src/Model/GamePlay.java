package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author thanhtri
 */
public class GamePlay implements Serializable{
    
    List<MySnake> playerList = new ArrayList<MySnake>();
    
    // food
    public static int[] foodMapX = {20,40,60,80,100,120,140,160,180,200,220,240,260,280,300,320,340,360,380,400,420,440,460,480,500,520,540,560,580,600,620,640,660,680,700,720,740};
    public static int[] foodMapY = {60,80,100,120,140,160,180,200,220,240,260,280,300,320,340,360,380,400,420,440};
    private int[] foodXPos = new int [3];
    private int[] foodYPos = new int [3];
    private Random rand = new Random();
    
    public GamePlay(){
        
        MySnake player1 = new MySnake(1);
        MySnake player2 = new MySnake(2);
        MySnake player3 = new MySnake(3);
        MySnake player4 = new MySnake(4);
    
        for (int i = 0; i < 3; i++) {
            foodXPos[i] = foodMapX[rand.nextInt(36)];
            foodYPos[i] = foodMapY[rand.nextInt(19)];
        }       
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
    }
    
    public GamePlay createSamePattern() {
        GamePlay pattern = new GamePlay();
        for (int i = 0; i < 3; i++) {
            pattern.getFoodXPos()[i] = this.foodXPos[i];
            pattern.getFoodYPos()[i] = this.foodYPos[i];
        }
        pattern.setRand(this.rand);
        for (int i = 0; i < 4; i++) {
            pattern.getPlayerList().get(i).setSnakeLen(this.playerList.get(i).getSnakeLen());
            pattern.getPlayerList().get(i).setPlaying(this.playerList.get(i).isPlaying());
            pattern.getPlayerList().get(i).setLeft(this.playerList.get(i).isLeft());
            pattern.getPlayerList().get(i).setRight(this.playerList.get(i).isRight());
            pattern.getPlayerList().get(i).setUp(this.playerList.get(i).isUp());
            pattern.getPlayerList().get(i).setDown(this.playerList.get(i).isDown());
            for (int j = 0; j < pattern.getPlayerList().get(i).getSnakeLen(); j++) {
                pattern.getPlayerList().get(i).getxSnake()[j] = this.playerList.get(i).getxSnake()[j];
                pattern.getPlayerList().get(i).getySnake()[j] = this.playerList.get(i).getySnake()[j];
            }
        }
        return pattern;
    }

    public List<MySnake> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<MySnake> playerList) {
        this.playerList = playerList;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public int[] getFoodXPos() {
        return foodXPos;
    }

    public void setFoodXPos(int[] foodXPos) {
        this.foodXPos = foodXPos;
    }

    public int[] getFoodYPos() {
        return foodYPos;
    }

    public void setFoodYPos(int[] foodYPos) {
        this.foodYPos = foodYPos;
    }
}
