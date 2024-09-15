package view;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import model.Message;

/**
 * The PlaintextField is a text area that displays the plaintext portion
 * of a message.
 */
public class PlaintextField extends JTextArea implements MessageListener {
    
    private Message msg;
    
    /**
     * Creates the text area
     * @param height the text area height
     * @param width the text area width
     * @param msg the message whose plaintext is displayed in this area
     */
    public PlaintextField (int height, int width, Message msg) {
        super(height, width);
        setBorder(BorderFactory.createTitledBorder("Plain text"));
        this.msg = msg;
    }

    @Override
    /**
     * Updates the text area when the plain text of the message changes.
     */
    public void update() {
        setText(msg.getPlaintext());
    }

}
