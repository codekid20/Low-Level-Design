package strategy;

import java.security.SecureRandom;

public class RandomNumericCodeStrategy implements CodeGenerationStrategy {

    private static final SecureRandom RANDOM = new SecureRandom(); // ??
    private static final int CODE_LENGTH = 6;

    @Override
    public String generateCode() {
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(RANDOM.nextInt(10));
        }

        return sb.toString();
    }
}
