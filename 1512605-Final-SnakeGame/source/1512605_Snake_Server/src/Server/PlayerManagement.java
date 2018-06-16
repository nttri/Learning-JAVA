package Server;

import Model.Room;
import Model.SendMessage;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanhtri
 */
public class PlayerManagement {

    List<String> playerNameList = new ArrayList<String>();
    List<RoomManagement> manageRoomList = new ArrayList<RoomManagement>();
    List<SendMessage> clientList = new ArrayList<SendMessage>();
    
    public static int random() {
        Random random = new Random();
        int randomNum = 1000 + random.nextInt(8900);
        return randomNum;
    }

    public List<String> checkPlayerName(String name, InetAddress address, int port) {
        for (int i = 0; i < playerNameList.size(); i++) {
            if (name.equals(playerNameList.get(i))) {
                return null;
            }
        }
        playerNameList.add(name);
        clientList.add(new SendMessage(address, port));
        for (int i = 0; i < clientList.size() - 1; i++) {
            clientList.get(i).sendNewPlayer(name);
        }
        return playerNameList;
    }

    public RoomManagement createRoom(String leaderName) {
        int idx = random();
        int res = checkPort(idx);

        while (idx < 1) {
            idx = random();
        }
        if (res != -1) {
            int index = playerNameList.indexOf(leaderName);
            Room room = new Room(idx, leaderName);
            RoomManagement roomManage = new RoomManagement(room, clientList.get(index));
            manageRoomList.add(roomManage);
            return roomManage;
        }
        return null;
    }

    public RoomManagement joinRoom(String name, int port) {
        int check = checkRoom(port);
        if (check == -1) {
            return null;
        }
        for (int i = 0; i < manageRoomList.size(); i++) {
            if (manageRoomList.get(i).getRoomID() == port) {
                int index = playerNameList.indexOf(name);
                if (manageRoomList.get(i).addPlayerToRoom(name, clientList.get(index))) {
                    return manageRoomList.get(i);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public void removeRoom(RoomManagement roomManage) {
        manageRoomList.remove(roomManage);
    }

    public void exitGame(String playerName) {
        try {
            int i = playerNameList.indexOf(playerName);
            playerNameList.remove(i);
            clientList.get(i).exit();
            clientList.get(i).gSocket.close();
            clientList.remove(i);
            for (int j = 0; j < clientList.size(); j++) {
                clientList.get(j).sendPlayerExitGame(playerName);
            }
        } catch (IOException ex) {
            Logger.getLogger(PlayerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int checkRoom(int id) {

        for (int i = 0; i < manageRoomList.size(); i++) {
            if (manageRoomList.get(i).getRoomID() == id) {
                return i;
            }
        }
        return -1;
    }

    public int checkPort(int id) {
        if (id == Common.gPort) {
            return -1;
        }
        for (int i = 0; i < manageRoomList.size(); i++) {
            if (manageRoomList.get(i).getRoomID() == id) {
                return -1;
            }
        }
        return id;
    }

}
