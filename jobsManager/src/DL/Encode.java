/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DL;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author BB
 */
public class Encode {

    private PrivateKey priKey;
    private PublicKey pubKey;

    public Encode() {
        getKeys();
    }
    
    public void createKey() {

        try {
            KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
            key.initialize(512);
            KeyPair keys = key.genKeyPair();
            PrivateKey privateKey = keys.getPrivate();
            PublicKey publicKey = keys.getPublic();
            X509EncodedKeySpec x509EncodedKeySpec
                    = new X509EncodedKeySpec(publicKey.getEncoded());
            FileOutputStream f = new FileOutputStream("src/Data/pubKey.dat");
            f.write(x509EncodedKeySpec.getEncoded());
            f.close();
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec
                    = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            f = new FileOutputStream("src/Data/priKey.dat");
            f.write(pkcs8EncodedKeySpec.getEncoded());
            f.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Encode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | NoSuchAlgorithmException ex) {
            Logger.getLogger(Encode.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }

    private void getKeys() {
        try {
            File pubKeyFile = new File("src/Data/pubKey.dat");
            File privKeyFile = new File("src/Data/priKey.dat");
            DataInputStream dis = new DataInputStream(new FileInputStream(pubKeyFile));
            byte[] pubKeyBytes = new byte[(int) pubKeyFile.length()];
            dis.readFully(pubKeyBytes);
            dis.close();

            // đọc dữ liệu từ file và khởi tọa lại khóa mật
            dis = new DataInputStream(new FileInputStream(privKeyFile));
            byte[] privKeyBytes = new byte[(int) privKeyFile.length()];
            dis.read(privKeyBytes);
            dis.close();
            //
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            // Tạo khóa công khai
            X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubKeyBytes);
            pubKey = (RSAPublicKey) keyFactory.generatePublic(pubSpec);
            // tạo khóa mật
            PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(privKeyBytes);
            priKey = (RSAPrivateKey) keyFactory.generatePrivate(privSpec);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println("ERR: " + ex.toString());
        }
    }

    // hàm mã hóa
    public byte[] Encrypt(byte[] data) {
        try {
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, priKey);
            byte[] rs = c.doFinal(data);
            return rs;
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            System.out.println("Err: " + ex.toString());
        }
        return null;
    }

    // hàm giải mã
    public byte[] Decrypt(byte[] data) {
        try {
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, pubKey);
            byte[] rs = c.doFinal(data);
            return rs;
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            System.out.println("Err: " + ex.toString());
        }
        return null;
    }

}
