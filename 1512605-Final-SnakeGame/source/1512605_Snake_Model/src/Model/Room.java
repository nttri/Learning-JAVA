package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanhtri
 */
public class Room implements Serializable {
    
    int ID;
    List<String> PlayerNameList = new ArrayList<String>();
    int Status;

    public Room() {
    }
    
    public Room(int id, int status) {
        this.ID = id;
        this.Status = status;
    }

    public Room(int id, String RoomLeaderName) {
        this.ID = id;
        this.Status = 0;
        PlayerNameList.add(RoomLeaderName);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<String> getPlayerNameList() {
        return PlayerNameList;
    }

    public void setPlayerNameList(List<String> PlayerNameList) {
        this.PlayerNameList = PlayerNameList;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    public void addPlayer(String playerName) {
	PlayerNameList.add(playerName);
    }

    public int removePlayer(String playerName) {
	int index = PlayerNameList.indexOf(playerName);
	PlayerNameList.remove(playerName);
	return index;
    }
    
    public String getPlayerName(int index) {
	try {
	    return this.PlayerNameList.get(index);
	} catch (Exception ex) {
            //
	}
	return "  ";
    }
    
}
