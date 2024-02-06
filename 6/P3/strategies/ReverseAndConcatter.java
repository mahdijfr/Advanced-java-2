package strategies;

public class ReverseAndConcatter implements EncryptionDecryptionStrategy {
	@Override
	public String encrypt(String message, int key) {
		return new StringBuilder(message)
				.reverse()
				.append(key)
				.toString();
	}

	@Override
	public String decrypt(String message, int key) {
		return new StringBuilder(message)
				.reverse()
				.delete(0, Integer.toString(key).length())
				.toString();
	}
}
