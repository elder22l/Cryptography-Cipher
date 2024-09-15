package model;

public class Copy implements encryptionAlgorithm {
    private Message msg;
    public Copy(Message msg) {
        this.msg = msg;
    }
   //copies a message
   //@param:(un-used) a key
   // @return: the ecrypted message
    public String encrypt(int key) {
        String messageToUse = msg.getPlaintext();
        return messageToUse; 
    }
    //copies a message
    //@param:(un-used) a key
    // @return: the ecrypted message
    public String decrypt(int key) {
        String messageToUse = msg.getPlaintext();
        return messageToUse; 
    } 

}
