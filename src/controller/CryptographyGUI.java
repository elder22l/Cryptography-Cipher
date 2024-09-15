package controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Caesar;
import model.Copy;
import model.Message;
import model.Scytale;
import view.DropDownAlgorithm;
import view.EncryptedField;
import view.PlaintextField;


/**
 * This class provides a graphical user interface that allows a user to enter
 * text and select an encryption algorithm and key to encrypt the text. The user
 * can also enter encrypted text, select an algorithm and key to decrypt the
 * text.
 *
 */
public class CryptographyGUI  {
    // The width of the text areas for entering encrypted and decrypted text,
    // in characters
    private static final int TEXT_WIDTH = 50;

    // The number of rows in the text areas for entering encrypted and decrypted
    // text,
    // in characters
    private static final int TEXT_HEIGHT = 5;
    
    // Error message if the user does not enter a number for the key.
    private static final String KEY_ERROR_MESSAGE = 
            "Enter a number for the key.";

    // The three kinds of encryption we know. These go in the menu.
    private static final String CAESAR = "Caesar cipher";
    private static final String SCYTALE = "Scytale";
    private static final String COPY = "Copy";

    private Message message = new Message();

    // Where the unencrypted text appears on the screen
    private PlaintextField plainTextArea = new PlaintextField(TEXT_HEIGHT, TEXT_WIDTH, message);

    // Where the encrypted text appears on the screen
    private EncryptedField cipherTextArea = new EncryptedField(TEXT_HEIGHT, TEXT_WIDTH, message);
    
    //encyption algorithm to use
    private DropDownAlgorithm algorithmToUse = new DropDownAlgorithm(message);
    
    //cipher combo box 
    private JComboBox comboBox;
    //key text box
    private JTextField keyField = new JTextField(15);
    
    //encrypt button
    private JButton encryptButton;
    
    //decrypt button
    private JButton decryptButton;
    
    

    /**
     * Constructs the user interface for the program.
     */
    public CryptographyGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //ComboBox creation
        JPanel encryptionPanel = createEncryptionPanel();

        // Add the listeners to the text fields.
        message.addListener(plainTextArea);
        message.addListener(cipherTextArea);  
        message.addListener(algorithmToUse);
        
        // Add action listener to the encrypt button
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected algorithm
                String selectedAlgorithm = (String) comboBox.getSelectedItem();
                
                // Get key
                
                int key; 
                try {key = Integer.parseInt(keyField.getText());
                } catch (NumberFormatException ex) {
                   System.out.println(KEY_ERROR_MESSAGE);
                   return;
                }
                
                message.setPlaintext(plainTextArea.getText());

                // Encrypt with selected algorithm and key
                if (selectedAlgorithm.equals(CAESAR)) {
                    message.setEncryptionAlgorithm(new Caesar(message)); 
                } else if (selectedAlgorithm.equals(SCYTALE)) {
                    message.setEncryptionAlgorithm(new Scytale(message)); 
                } else if (selectedAlgorithm.equals(COPY)) {
                    message.setEncryptionAlgorithm(new Copy(message)); 
                }

                // Call encrypt method
                message.encryptWithKey(key);
            }
            
        
        });
        
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected algorithm
                String selectedAlgorithm = (String) comboBox.getSelectedItem();
                
                //get key
                int key; 
                try {key = Integer.parseInt(keyField.getText());
                } catch (NumberFormatException ex) {
                   System.out.println(KEY_ERROR_MESSAGE);
                   return;
                }
                
                message.setPlaintext(plainTextArea.getText());

                // Encrypt with selected algorithm and key
                if (selectedAlgorithm.equals(CAESAR)) {
                    message.setEncryptionAlgorithm(new Caesar(message)); 
                } else if (selectedAlgorithm.equals(SCYTALE)) {
                    message.setEncryptionAlgorithm(new Scytale(message)); 
                } else if (selectedAlgorithm.equals(COPY)) {
                    message.setEncryptionAlgorithm(new Copy(message)); 
                }

                // Call encrypt method
                message.decryptWithKey(key);
            }
            
        
        });
        // Add all the GUI elements to the display.
        frame.add(plainTextArea, BorderLayout.NORTH);
        frame.add(cipherTextArea, BorderLayout.CENTER);
        frame.add(encryptionPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }
    
    //initializing the encryption panel
    private JPanel createEncryptionPanel() {
        JPanel encryptionPanel = new JPanel();
        //adding the encrypt and decrypt buttons
        encryptButton = new JButton("encrypt");
        decryptButton = new JButton("decrypt");
        encryptionPanel.add(encryptButton);
        encryptionPanel.add(decryptButton);
       
        //adding the comboBox cipher options
        comboBox = new JComboBox();
        comboBox.addItem(COPY);
        comboBox.addItem(CAESAR);
        comboBox.addItem(SCYTALE);
        encryptionPanel.add(comboBox);
        
        //adding the key text field
        encryptionPanel.add(new JLabel ("key: "));
        encryptionPanel.add(keyField);

        return encryptionPanel;
    }

    /**
     * The main method to start the program.
     * 
     * @param args None required
     */
    public static void main(String[] args) {
        new CryptographyGUI();
    }

}
