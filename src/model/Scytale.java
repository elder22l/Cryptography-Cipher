package model;

public class Scytale implements encryptionAlgorithm {
    Message msg = new Message();
    public Scytale(Message msg) {
        this.msg = msg;
        // TODO Auto-generated constructor stub
    }
    //encrypts using a key with the scytale cipher
    //@param: a key
   // @return: the ecrypted message
    public String encrypt(int key) {
        String messageToUse = msg.getPlaintext();
        int messageLength = messageToUse.length();
        
        StringBuilder stringToReturn = new StringBuilder();
        

        for(int i = 0; i < key; i ++) {
            
            //using i, keeps track of which column is being updated, and adds
            //the key amount to go on to the next letter that needs to be added
            //to the stringToRerun
            for(int j = 0; i + j < messageLength; j += key) {
                stringToReturn.append(messageToUse.charAt(i + j));
            }
        }
        
        
        return stringToReturn.toString(); 
    }
    //decrypts using a key with the scytale cipher
    //@param: a key
   // @return: the ecrypted message
    public String decrypt(int key) {
        String messageToUse = msg.getPlaintext();
        int messageLength = messageToUse.length();
        
        int columns = messageLength/key;
        if(messageLength%key != 0) {
            columns ++;
        }

        StringBuilder stringToReturn = new StringBuilder();
        //iterate over columns
        for (int i = 0; i < columns; i++) {
            //iterate over each row in the column
            for (int j = 0; j < key; j++) {
                int index = i+j * columns;
                if (index < messageLength) {
                    stringToReturn.append(messageToUse.charAt(index));
                }
            }
        }

        
        return stringToReturn.toString(); 
    } 

}


