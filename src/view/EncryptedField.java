package view;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import model.Message;

/**
 * A JTextArea to display the encrypted portion of a message.
 */
public class EncryptedField extends JTextArea implements MessageListener {
    
    private Message msg;
    
    /**
     * Creates the text area
     * @param height the text area height
     * @param width the text area width
     * @param msg the message whose encrypted text is displayed in this area
     */
    public EncryptedField (int height, int width, Message msg) {
        super(height, width);
        setBorder(BorderFactory.createTitledBorder("Cipher text"));
        this.msg = msg;
    }

    @Override
    /**
     * Updates the text area when the encrypted text of the message changes.
     */
    public void update() {
        setText(msg.getEncrypted());
    }

}
