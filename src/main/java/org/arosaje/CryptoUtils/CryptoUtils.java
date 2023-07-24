package org.arosaje.CryptoUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class CryptoUtils {
    private static final String AES_ALGORITHM = "AES";
    private static final String AES_KEY = "5D9r9Ldai72uv3KcMqkM2wzQ5v6SbA2LQ1HJ3aBtErU=";


    public static String encrypt(String message) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(AES_KEY);
        SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes).replaceAll("\\s+", "");
    }

    public static String decrypt(String encryptedMessage) throws Exception {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(AES_KEY);
            SecretKeySpec secretKeySpec = new SecretKeySpec(decodedKey, AES_ALGORITHM);
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);

            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            // Gérer les exceptions liées au déchiffrement ici
            e.printStackTrace();
            throw new Exception("Erreur lors du déchiffrement");
        }
    }
}