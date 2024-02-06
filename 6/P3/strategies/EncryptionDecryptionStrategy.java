package strategies;

public interface EncryptionDecryptionStrategy {
	public String encrypt(String message, int key);
	
	public String decrypt(String message, int key);
}
