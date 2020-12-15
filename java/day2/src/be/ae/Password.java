package be.ae;

public class Password {

    int min, max;
    char c;
    String password;

    public Password(int min, int max, char c, String password) {
        this.min = min;
        this.max = max;
        this.c = c;
        this.password = password;
    }

    public boolean isValid() {
        long charCount = password.chars().filter(ch -> ch == c).count();
        Boolean result = charCount >= min && charCount <= max;
        System.out.println("Result: " + result +
                " for charCount:" + charCount +
                ", min & max: " + min + " - " + max +
                " for password '" + password + "'");
        return result;
    }

    public boolean isValid2() {
        boolean v1 = password.charAt(min - 1) == c;
        boolean v2 = password.charAt(max - 1) == c;
        return (v1 != v2);
    }
}
