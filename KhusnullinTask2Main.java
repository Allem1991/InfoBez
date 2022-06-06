import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class KhusnullinTask2Main {
	
    public static void main(String[] args) throws InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        byte[] encodedBytesFirst = new byte[0];
		
        byte[] encodedBytes = new byte[0];
		
        KhusnullinTask2Cbc task = null;

        try {
			
            task = new KhusnullinTask2Cbc();
            encodedBytesFirst = task.encode("alert(\"You are pwned!\");");
            encodedBytes = task.encode("alert(\"Hello world!\");");
			
        } 
		catch (IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
			
        }

        int newLength = encodedBytes.length + encodedBytesFirst.length;
        System.out.println("length" + newLength);
        byte[] newArray = new byte[newLength];

        for (int i = 0; i < encodedBytesFirst.length; i++) {
			
            newArray[i] = encodedBytesFirst[i];
            newArray[i + encodedBytesFirst.length] = encodedBytes[i];
			
        }

        System.out.println(new String(encodedBytes));
        System.out.println(new String(task.decode(newArray)));
		
    }
	
}