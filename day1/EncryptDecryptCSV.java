package org.day1;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;
import java.util.Arrays;

public class EncryptDecryptCSV {
    private static final String AES = "AES";
    private static final String CSV_FILE = "C:\\Users\\kumar\\OneDrive\\Desktop\\employees.csv";
    private static final String ENCRYPTED_CSV = "C:\\Users\\kumar\\OneDrive\\Desktop\\encrypted_employees.csv";
    private static final String DECRYPTED_CSV = "C:\\Users\\kumar\\OneDrive\\Desktop\\decrypted_employees.csv";

    // Generate AES key
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(AES);
        keyGen.init(128);
        return keyGen.generateKey();
    }

    // Encrypt data
    private static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt data
    private static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    // Write encrypted CSV
    public static void encryptAndWriteCSV(SecretKey key) {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE));
             CSVWriter writer = new CSVWriter(new FileWriter(ENCRYPTED_CSV))) {

            String[] row;
            writer.writeNext(reader.readNext()); // Write headers

            while ((row = reader.readNext()) != null) {
                row[2] = encrypt(row[2], key); // Encrypt Email
                row[3] = encrypt(row[3], key); // Encrypt Salary
                writer.writeNext(row);
            }

            System.out.println("Encrypted CSV written successfully: " + ENCRYPTED_CSV);
        } catch (Exception e) {
            System.out.println("Error during encryption: " + e.getMessage());
        }
    }

    // Read encrypted CSV and decrypt
    public static void readAndDecryptCSV(SecretKey key) {
        try (CSVReader reader = new CSVReader(new FileReader(ENCRYPTED_CSV));
             CSVWriter writer = new CSVWriter(new FileWriter(DECRYPTED_CSV))) {

            String[] row;
            writer.writeNext(reader.readNext()); // Write headers

            while ((row = reader.readNext()) != null) {
                row[2] = decrypt(row[2], key); // Decrypt Email
                row[3] = decrypt(row[3], key); // Decrypt Salary
                writer.writeNext(row);
            }

            System.out.println("Decrypted CSV written successfully: " + DECRYPTED_CSV);
        } catch (Exception e) {
            System.out.println("Error during decryption: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            SecretKey key = generateKey();

            // Encrypt and write CSV
            encryptAndWriteCSV(key);

            // Read and decrypt CSV
            readAndDecryptCSV(key);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

