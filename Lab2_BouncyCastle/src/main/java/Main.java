import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.io.FileInputStream;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Main {
    public static void main(String[] args) throws Exception {

        int maxKeySize = javax.crypto.Cipher.getMaxAllowedKeyLength("AES");
        System.out.println("Max Key Size for AES : " + maxKeySize);

        Security.addProvider(new BouncyCastleProvider());
        CertificateFactory certFactory= CertificateFactory
                .getInstance("X.509", "BC");
        X509Certificate certificate = (X509Certificate) certFactory
                .generateCertificate(new FileInputStream("./src/main/resources/public.cer"));
        char[] keystorePassword = "password".toCharArray();
        char[] keyPassword = "password".toCharArray();
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        keystore.load(new FileInputStream("./src/main/resources/private.p12"), keystorePassword);
        PrivateKey privateKey = (PrivateKey) keystore.getKey("baeldung",
                keyPassword);

        String secretMessage = "My password is 123456Seven";
        System.out.println("Original Message : " + secretMessage);

        byte[] stringToEncrypt = secretMessage.getBytes();
        byte[] encryptedData = Encryptor.encryptData(stringToEncrypt, certificate);
        System.out.println("Encrypted Message : " + new String(encryptedData));

        byte[] rawData = Encryptor.decryptData(encryptedData, privateKey);
        String decryptedMessage = new String(rawData);
        System.out.println("Decrypted Message : " + decryptedMessage);

        byte[] signedData = Verifier.signData(rawData, certificate, privateKey);
        Boolean check = Verifier.verifySignedData(signedData);
        System.out.println(check);

    }
}
