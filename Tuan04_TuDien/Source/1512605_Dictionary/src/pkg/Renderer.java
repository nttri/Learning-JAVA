package pkg;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author thanhtri - 1512605
 */
public class Renderer extends DefaultListCellRenderer implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Word word = (Word) value;

        setText(word.getWord() + " [" + word.getnSearch() + "]");
        Icon icon = null;
        if (word.getIsFavorite()) {
            icon = new ImageIcon("resource\\green-heart.png");
        }
        setIcon(icon);

        //SET BACKGROUND AND FOREGROUND COLORS TO CUSTOM LIST ROW
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {

            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setEnabled(true);
        setFont(list.getFont());

        return this;
    }
}
