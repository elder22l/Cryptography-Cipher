package model;

import java.util.ArrayList;
import java.util.List;

import view.MessageListener;

/**
 * A message contains a plaintext value and an encrypted value.
 */
public class Message {
    private String plaintext = "";
    private String encrypted = "";
    encryptionAlgorithm encryptionToUse;
    
    private List<MessageListener> listeners = new ArrayList<>();
    
    
    
    /**
     * Encrypts the plaintext using the currently selected algorithm
     * @param key the key the algorithm should use
     */
    public void encryptWithKey(int key) {
        String encryptedText = encryptionToUse.encrypt(key);
        setEncrypted(encryptedText);
        notifyListeners();
    }
    
    /**
     * Decrypts the cipher text using the currently selected algorithm
     * @param key the key the algorithm should use
     */
    public void decryptWithKey(int key) {
        String decryptedText = encryptionToUse.decrypt(key);
        setEncrypted(decryptedText);
        notifyListeners();
    }
    
    /**
     * Add a listener to the counter's list of listeners.  The listener will 
     * be notified when the counter's value changes.
     * @param listener the listener to add.
     */
    public void addListener(MessageListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (MessageListener listener : listeners) {
            listener.update();
        }
    }
    
    public String getPlaintext() {
        return plaintext;
    }
    
    public String getEncrypted() {
        return encrypted;
    }
    
    public encryptionAlgorithm getEncryptionAlgorithm() {
        return encryptionToUse;
    }
    
    public void setEncryptionAlgorithm(encryptionAlgorithm encryptionToUse) {
        this.encryptionToUse = encryptionToUse;
    }
    
    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }

}
