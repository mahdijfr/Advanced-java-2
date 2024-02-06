package strategies;

public class f {
    public String encrypt(String message, int key) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			sb.append(shiftChar(message.charAt(i), (i % 2 == 0) ? key : -key));
		}

		return sb.toString();
	}

	public String decrypt(String message, int key) {
		return encrypt(message, -key);
	}

	public static char shiftChar(char c, int key) {
        if (Character.isUpperCase(c)) {
            return (char) (((c - 'A' + 26 + key) % 26) + 'A');
        } 
        else if (Character.isLowerCase(c)) {
            return (char) (((c - 'a' + 26 + key) % 26) + 'a');
        } 
        else {
            return c;
        }
		
    }

    public static void main(String[] args) {
        f f = new f();
        System.out.println(f.encrypt("Hello World", 5));
        System.out.println(f.decrypt("Hf rqxq rqxq", 1));
    }
}
