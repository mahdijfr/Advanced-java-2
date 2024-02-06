package strategies;

public class CaesarCipher implements EncryptionDecryptionStrategy {
	@Override
	public String encrypt(String message, int key) {
		return message.chars()
                    .map(c -> shiftChar((char) c, key))
                    .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                        .toString();
	}

	@Override
	public String decrypt(String message, int key) {
		return encrypt(message, -key);
	}

	private static char shiftChar(char c, int key) {
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
