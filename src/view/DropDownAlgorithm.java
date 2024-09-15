package view;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import model.Message;
import model.encryptionAlgorithm;

public class DropDownAlgorithm extends JComboBox implements MessageListener {
    private Message msg;
    
    public DropDownAlgorithm(Message message) {
        this.msg = message;
   
    }

    @Override
    public void update() {
        setSelectedItem(msg.getEncryptionAlgorithm());
    }
    

}
