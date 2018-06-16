package Model;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author thanhtri
 */
public class MySnake implements Serializable{

    private int scores;
    private int snakeLen;
    public int[] xSnake = new int[800];
    public int[] ySnake = new int[800];
    private boolean playing = false;
    private int moves = 0;
    // Directions
    private boolean up = false;
    private boolean left = false;
    private boolean right = true;
    private boolean down = false;

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
    
    public int[] getxSnake() {
        return xSnake;
    }

    public void setxSnake(int[] xSnake) {
        this.xSnake = xSnake;
    }

    public int[] getySnake() {
        return ySnake;
    }

    public void setySnake(int[] ySnake) {
        this.ySnake = ySnake;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    
    public MySnake(int playerNumber) {
        this.scores = 0;
        this.snakeLen = 3;
        if (playerNumber == 1) {
            this.xSnake[0] = 100;
            this.xSnake[1] = 80;
            this.xSnake[2] = 60;
            this.ySnake[0] = this.ySnake[1] = this.ySnake[2] = 60;
        }
        if (playerNumber == 2) {
            this.xSnake[0] = this.xSnake[1] = this.xSnake[2] = 700;
            this.ySnake[0] = 120;
            this.ySnake[1] = 100;
            this.ySnake[2] = 80;
        }
        if (playerNumber == 3) {
            this.xSnake[2] = 100;
            this.xSnake[1] = 80;
            this.xSnake[0] = 60;
            this.ySnake[0] = this.ySnake[1] = this.ySnake[2] = 260;
        }
        if (playerNumber == 4) {
            this.xSnake[0] = this.xSnake[1] = this.xSnake[2] = 700;
            this.ySnake[0] = 380;
            this.ySnake[1] = 360;
            this.ySnake[2] = 340;
        }
    }

    public void refresh() {
        this.scores = 0;
        this.snakeLen = 3;
        this.xSnake[0] = 100;
        this.xSnake[1] = 80;
        this.xSnake[2] = 60;
        this.ySnake[0] = this.ySnake[1] = this.ySnake[2] = 60;
    }

    public int getSnakeLen() {
        return snakeLen;
    }

    public void setSnakeLen(int snakeLen) {
        this.snakeLen = snakeLen;
    }

    public void increaseScore() {
        this.scores += 10;
    }

    public void increaseMoves() {
        this.moves++;
    }

    public void increaseLength() {
        this.snakeLen++;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public void goLeft() {
        for (int i = snakeLen - 1; i >= 0; i--) {
            ySnake[i + 1] = ySnake[i];
        }
        for (int i = snakeLen - 1; i >= 0; i--) {
            if (i == 0) {
                xSnake[i] = xSnake[i] - 20;
            } else {
                xSnake[i] = xSnake[i - 1];
            }
            if (xSnake[i] < 0) {
                xSnake[i] = 800 - 20;
            }
        }
    }

    public void goRight() {
        for (int i = snakeLen - 1; i >= 0; i--) {
            ySnake[i + 1] = ySnake[i];
        }
        for (int i = snakeLen - 1; i >= 0; i--) {
            if (i == 0) {
                xSnake[i] = xSnake[i] + 20;
            } else {
                xSnake[i] = xSnake[i - 1];
            }
            if (xSnake[i] > 800 - 20) {
                xSnake[i] = 0;
            }
        }
    }

    public void goUp() {
        for (int i = snakeLen - 1; i >= 0; i--) {
            xSnake[i + 1] = xSnake[i];
        }
        for (int i = snakeLen - 1; i >= 0; i--) {
            if (i == 0) {
                ySnake[i] = ySnake[i] - 20;
            } else {
                ySnake[i] = ySnake[i - 1];
            }
            if (ySnake[i] < 40) {
                ySnake[i] = 520 - 60;
            }
        }
    }

    public void goDown() {
        for (int i = snakeLen - 1; i >= 0; i--) {
            xSnake[i + 1] = xSnake[i];
        }
        for (int i = snakeLen - 1; i >= 0; i--) {
            if (i == 0) {
                ySnake[i] = ySnake[i] + 20;
            } else {
                ySnake[i] = ySnake[i - 1];
            }
            if (ySnake[i] > 520 - 60) {
                ySnake[i] = 40;
            }
        }
    }

}
