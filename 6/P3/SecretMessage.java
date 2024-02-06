
import exceptions.*;
import strategies.EncryptionDecryptionStrategy;

public class SecretMessage {
	String message;
	boolean encrypted;


	public SecretMessage(String message) {
		this.message = message;
		this.encrypted = false;
	}

	public String getMessage() {
		return message;
	}

	public boolean isEncrypted() {
		return encrypted;
	}

	public void encrypt(EncryptionDecryptionStrategy strategy, int key)
			throws MessageAlreadyEncryptedException, WrongKeyException {
		if (isEncrypted()) {
			throw new MessageAlreadyEncryptedException();
		} else if (key <= 0) {
			throw new WrongKeyException();
		} else {
			message = strategy.encrypt(message, key);
			encrypted = true;
		}
	}

	public void decrypt(EncryptionDecryptionStrategy strategy, int key)
			throws MessageAlreadyDecryptedException, WrongKeyException {
		if (!isEncrypted()) {
			throw new MessageAlreadyDecryptedException();
		} else if (key <= 0) {
			throw new WrongKeyException();
		} else {
			message = strategy.decrypt(message, key);
			encrypted = false;
		}
	}
}
