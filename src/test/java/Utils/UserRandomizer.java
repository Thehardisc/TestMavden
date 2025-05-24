package Utils;

import java.util.Random;

public class UserRandomizer {
    private static UserRandomizer instance;
    private String generatedUsername;
    private String generatedPassword;
    private UserRandomizer() {}

    public String generateUsername() {
        Random random = new Random();
        this.generatedUsername = "test" + random.nextInt(100000000);
        return this.generatedUsername;
    }

    public String generatePassword() {
        Random random = new Random();
        this.generatedPassword = "test" + random.nextInt(100000000);
        return this.generatedPassword;
    }

    public String getGeneratedUsername() {
        return this.generatedUsername;
    }

    public String getGeneratedPassword() {
        return this.generatedPassword;
    }

    public static UserRandomizer getInstance() {
        if (instance == null) {
            instance = new UserRandomizer();
        }
        return instance;
    }
}
