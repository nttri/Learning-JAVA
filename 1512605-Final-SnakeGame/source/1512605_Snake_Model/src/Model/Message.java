package Model;

import java.io.Serializable;

/**
 *
 * @author thanhtri
 */
public class Message implements Serializable{
    
    String title;       // đa phần là tên hàm
    Object content;     // nội dung gửi theo
    
    public Message(String _title, Object _content) {
	this.title = _title;
	this.content = _content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object _content) {
        this.content = _content;
    }
    
    public String getString() {
	return String.valueOf(this.content);
    }

    public int getInt() {
	return Integer.parseInt(String.valueOf(this.content));
    }

    public boolean getBoolean() {
	return Boolean.parseBoolean(String.valueOf(this.content));
    }
    
}
