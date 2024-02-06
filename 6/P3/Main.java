import exceptions.*;
import strategies.*;

public class Main {
	public static void main(String[] args) {
		EncryptorDecryptor ed1 = new EncryptorDecryptor(
				new ReverseAndConcatter());
		SecretMessage sm = new SecretMessage("Hello from anonymous!");
		try {
			System.out.println(ed1.encrypt(sm, 1400));
			System.out.println(sm.getMessage());
			System.out.println(ed1.encrypt(sm, 1400));
		} catch (MessageAlreadyEncryptedException e) {
			System.out.println("Message already encrypted.");
		} catch (WrongKeyException e) {
			System.out.println("Invalid key.");
		}
		try {
			System.out.println(ed1.decrypt(sm, 1400));
			System.out.println(sm.getMessage());
			System.out.println(ed1.decrypt(sm, 1400));
		} catch (MessageAlreadyDecryptedException e) {
			System.out.println("Message already decrypted.");
		} catch (WrongKeyException e) {
			System.out.println("Invalid key.");
		}

		EncryptorDecryptor ed2 = new EncryptorDecryptor(new CaesarCipher());
		System.out.println(ed2.encrypt("abcd", 2));
		System.out.println(ed2.decrypt("cdef", 2));

		EncryptorDecryptor ed3 = new EncryptorDecryptor(
				new AdvancedCaesarCipher());
		System.out.println(ed3.encrypt("Java", 3));
		System.out.println(ed3.decrypt("Mxyx", 3));
	}
}
