/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Model.GamePlay;
import Model.Room;
import Model.SendMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanhtri
 */
public class RoomManagement {

    Room room = new Room();
    List<SendMessage> clientList = new ArrayList<>();
    public GamePlay gGamePlay;

    public RoomManagement(Room room, SendMessage sm) {
        this.clientList.add(sm);
        this.room = room;
    }

    public int getRoomID() {
        return room.getID();
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<SendMessage> getClientList() {
        return clientList;
    }

    public void setClientList(List<SendMessage> clientList) {
        this.clientList = clientList;
    }

    public void startPlaying() {
        gGamePlay = new GamePlay();
        for (int i = 0; i < clientList.size(); i++) {
            gGamePlay.getPlayerList().get(i).setPlaying(true);
        }
        for (int i = 0; i < clientList.size(); i++) {
            clientList.get(i).startPlaying(gGamePlay);
        }
    }

    /* 
    func: thêm 1 người chơi vào phòng
     */
    public Boolean addPlayerToRoom(String playerName, SendMessage player) {
        if (clientList.size() < 4) {
            for (int i = 0; i < clientList.size(); i++) {
                clientList.get(i).sendNewPlayerJoinRoom(playerName);
            }
            room.addPlayer(playerName);
            clientList.add(player);
            return true;
        }
        return false;
    }

    public void sendGamePlay() {
        Runnable mess = new Runnable() {
            @Override
            public void run() {
                boolean stop = false;
                while (stop == false) {
                    try {
                        eatFood();
                        collision();
                        GamePlay _gamePlay = gGamePlay.createSamePattern();
                        if (winGame()) {
                            for (int i = 0; i < clientList.size(); i++) {
                                clientList.get(i).winGame(_gamePlay);
                            }
                            gGamePlay = _gamePlay.createSamePattern();
                            break;
                        }
                        for (int i = 0; i < 4; i++) {
                            for (int z = _gamePlay.getPlayerList().get(i).getSnakeLen(); z > 0; z--) {
                                _gamePlay.getPlayerList().get(i).getxSnake()[z] = _gamePlay.getPlayerList().get(i).getxSnake()[(z - 1)];
                                _gamePlay.getPlayerList().get(i).getySnake()[z] = _gamePlay.getPlayerList().get(i).getySnake()[(z - 1)];
                            }
                            if (_gamePlay.getPlayerList().get(i).isLeft()) {
                                _gamePlay.getPlayerList().get(i).getxSnake()[0] -= 20;
                                if (_gamePlay.getPlayerList().get(i).getxSnake()[0] < 0) {
                                    _gamePlay.getPlayerList().get(i).getxSnake()[0] = 800 - 20;
                                }
                            }
                            if (_gamePlay.getPlayerList().get(i).isRight()) {
                                _gamePlay.getPlayerList().get(i).getxSnake()[0] += 20;
                                if (_gamePlay.getPlayerList().get(i).getxSnake()[0] > 800 - 20) {
                                    _gamePlay.getPlayerList().get(i).getxSnake()[0] = 0;
                                }
                            }
                            if (_gamePlay.getPlayerList().get(i).isUp()) {
                                _gamePlay.getPlayerList().get(i).getySnake()[0] -= 20;
                                if (_gamePlay.getPlayerList().get(i).getySnake()[0] < 40) {
                                    _gamePlay.getPlayerList().get(i).getySnake()[0] = 520 - 60;
                                }
                            }
                            if (_gamePlay.getPlayerList().get(i).isDown()) {
                                _gamePlay.getPlayerList().get(i).getySnake()[0] += 20;
                                if (_gamePlay.getPlayerList().get(i).getySnake()[0] > 520 - 60) {
                                    _gamePlay.getPlayerList().get(i).getySnake()[0] = 40;
                                }
                            }
                        }

                        for (int i = 0; i < clientList.size(); i++) {
                            clientList.get(i).sendGamePlay(_gamePlay);
                        }
                        gGamePlay = _gamePlay.createSamePattern();
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RoomManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        new Thread(mess).start();
    }

    public void playerMove(String[] str) {
        int index = this.room.getPlayerNameList().indexOf(str[0]);
        GamePlay pattern = gGamePlay.createSamePattern();
        if (str[1].equals("goLeft") && !pattern.getPlayerList().get(index).isRight()) {
            pattern.getPlayerList().get(index).setLeft(true);
            pattern.getPlayerList().get(index).setUp(false);
            pattern.getPlayerList().get(index).setDown(false);
        } else if (str[1].equals("goRight") && !pattern.getPlayerList().get(index).isLeft()) {
            pattern.getPlayerList().get(index).setRight(true);
            pattern.getPlayerList().get(index).setUp(false);
            pattern.getPlayerList().get(index).setDown(false);
        } else if (str[1].equals("goUp") && !pattern.getPlayerList().get(index).isDown()) {
            pattern.getPlayerList().get(index).setUp(true);
            pattern.getPlayerList().get(index).setLeft(false);
            pattern.getPlayerList().get(index).setRight(false);
        } else if (str[1].equals("goDown") && !pattern.getPlayerList().get(index).isUp()) {
            pattern.getPlayerList().get(index).setDown(true);
            pattern.getPlayerList().get(index).setLeft(false);
            pattern.getPlayerList().get(index).setRight(false);
        }
        gGamePlay = pattern.createSamePattern();
    }

    public void eatFood() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (gGamePlay.getPlayerList().get(j).isPlaying() && gGamePlay.getFoodXPos()[i] == gGamePlay.getPlayerList().get(j).getxSnake()[0]
                        && gGamePlay.getFoodYPos()[i] == gGamePlay.getPlayerList().get(j).getySnake()[0]) {
                    gGamePlay.getPlayerList().get(j).setSnakeLen(gGamePlay.getPlayerList().get(j).getSnakeLen() + 1);
                    Random rand = new Random();
                    gGamePlay.getFoodXPos()[i] = gGamePlay.foodMapX[rand.nextInt(36)];
                    gGamePlay.getFoodXPos()[i] = gGamePlay.foodMapY[rand.nextInt(19)];
                }
            }
        }
    }

    /* 
    func: kiểm tra game đã xong hay chưa
    */
    public void collision() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gGamePlay.getPlayerList().get(i).isPlaying() && gGamePlay.getPlayerList().get(j).isPlaying()) {
                    for (int k = 0; k < gGamePlay.getPlayerList().get(j).getSnakeLen(); k++) {
                        if (gGamePlay.getPlayerList().get(i).getxSnake()[0] == gGamePlay.getPlayerList().get(j).getxSnake()[k] && gGamePlay.getPlayerList().get(i).getySnake()[0] == gGamePlay.getPlayerList().get(j).getySnake()[k]) {
                            if (i != j || k != 0) {
                                gGamePlay.getPlayerList().get(i).setPlaying(false);
                            }
                        }
                    }
                }
            }
        }
    }

    /* 
    func: kiểm tra game đã xong hay chưa
    */
    public boolean winGame() {
        for (int i = 0; i < 4; i++) {
            if (gGamePlay.getPlayerList().get(i).isPlaying()) {
                return false;
            }
        }
        return true;
    }

    /* 
    func: xóa 1 người chơi ra khỏi phòng
    input: tên người chơi muốn xóa
    output: số lượng người còn trong phòng
     */
    public int removePlayerOutRoom(String playerName) {
        int index = room.removePlayer(playerName);
        clientList.remove(index);
        for (int i = 0; i < clientList.size(); i++) {
            clientList.get(i).sendPlayerExitRoom(playerName);
        }
        return room.getPlayerNameList().size();
    }

}
