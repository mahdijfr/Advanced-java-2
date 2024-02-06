package strategies;

public class AdvancedCaesarCipher implements EncryptionDecryptionStrategy {
	@Override
	public String encrypt(String message, int key) {
		StringBuilder encryptedMessage = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {
			encryptedMessage.append(shiftChar(message.charAt(i), (i % 2 == 0) ? key : -key));
		}

		return encryptedMessage.toString();
	}

	@Override
	public String decrypt(String message, int key) {
		return encrypt(message, -key);
	}

	public static char shiftChar(char c, int key) {
        if (Character.isUpperCase(c)) {
            return (char) (((c - 'A' + 26 + key%26) % 26) + 'A');
        } 
        else if (Character.isLowerCase(c)) {
            return (char) (((c - 'a' + 26 + key%26) % 26) + 'a');
        } 
        else {
            return c;
        }
    }
}
