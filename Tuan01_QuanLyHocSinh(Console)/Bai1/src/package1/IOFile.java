/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanhtri
 */
public class IOFile {
    public void write(List list, String fileName){
        try(FileOutputStream fos = new FileOutputStream(fileName)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch(Exception e){
            System.out.println("Have an exeception with write to file");
        }
    }
    
    public ArrayList read(String fileName){
        ArrayList list = new ArrayList();
        try(FileInputStream fis = new FileInputStream(fileName)){
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList)ois.readObject();
        } catch(Exception e){
            System.out.println("Data file does not exist now.");
        }
        return list;
    }
}
