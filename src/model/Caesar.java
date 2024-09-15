package model;

public class Caesar implements encryptionAlgorithm {
    Message msg = new Message();
    public Caesar(Message msg) {
        this.msg = msg;
        // TODO Auto-generated constructor stub
    }

    //encrypts using a key with the cesear cipher
    //@param: a key
   // @return: the ecrypted message
    public String encrypt(int key) {
        String startingMessage= msg.getPlaintext();
        char[] characterArray = startingMessage.toCharArray();
        
        String toReturn = "";
        StringBuilder stringToReturn = new StringBuilder();
        
        for (int i = 0; i < characterArray.length; i++) {
            char newCharacter = characterArray[i];
            newCharacter += key;
            stringToReturn.append(newCharacter);        
        }
       
                
        return stringToReturn.toString(); 
    }
    //decrypts using a key with the cesaer cipher
    //@param: a key
   // @return: the ecrypted message
    public String decrypt(int key) {
        String startingMessage= msg.getPlaintext();
        char[] characterArray = startingMessage.toCharArray();
        StringBuilder stringToReturn = new StringBuilder();
        
        for (int i = 0; i < characterArray.length; i++) {
            char newCharacter = characterArray[i];
            newCharacter -= key;
            stringToReturn.append(newCharacter);        
        }
       
                
        return stringToReturn.toString(); 
    }

}