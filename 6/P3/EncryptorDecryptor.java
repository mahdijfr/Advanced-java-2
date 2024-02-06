
import exceptions.*;
import strategies.EncryptionDecryptionStrategy;

public class EncryptorDecryptor {
	EncryptionDecryptionStrategy strategy;

	public EncryptorDecryptor(
			EncryptionDecryptionStrategy encryptorDecryptorStrategy) {
		this.strategy = encryptorDecryptorStrategy;
	}

	public String encrypt(SecretMessage message, int key)
			throws MessageAlreadyEncryptedException, WrongKeyException {
		message.encrypt(strategy, key);
		return message.getMessage();
	}

	public String encrypt(String message, int key) {
		return strategy.encrypt(message, key);
	}

	public String decrypt(SecretMessage message, int key)
			throws MessageAlreadyDecryptedException, WrongKeyException {
		message.decrypt(strategy, key);
		return message.getMessage();
	}

	public String decrypt(String message, int key) {
		return strategy.decrypt(message, key);
	}
}
