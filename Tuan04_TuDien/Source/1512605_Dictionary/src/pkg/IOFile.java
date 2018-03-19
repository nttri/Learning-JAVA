package pkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author thanhtri-1512605
 */
public class IOFile {
    
    public void ReadXML(HashMap hashMap, String fileName) throws Exception{
        
        File file = new File(fileName);
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        
        NodeList list = doc.getElementsByTagName("record");
        
        String word = "";
        String meaning = "";
        
        
        for(int i = 0; i < list.getLength(); i++){
            
            Node node = list.item(i);
            
            if(node.getNodeType() == Node.ELEMENT_NODE){
                
                Element ele = (Element)node;
                
                word = ele.getElementsByTagName("word").item(0).getTextContent();
                meaning = ele.getElementsByTagName("meaning").item(0).getTextContent();
                hashMap.put(word, meaning);
            }
        }
    }
    
    public void write(List list, String fileName){
        try(FileOutputStream fos = new FileOutputStream(new File(fileName))){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch(Exception e){
            System.out.println("Have an exeception with write to file");
        }
    }
    
    public ArrayList read(String fileName){
        ArrayList list = new ArrayList();
        try(FileInputStream fis = new FileInputStream(new File(fileName))){
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList)ois.readObject();
        } catch(Exception e){
            System.out.println("Have an exeception with read on file");
        }
        return list;
    }
}
