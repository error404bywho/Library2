package Security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class Encode {
	
	static KeyPairGenerator keyPairGenerator ;
	static KeyPair keyPair;
	
	public Encode() {
		//init KeyPair to use 
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2024); 	
			keyPair = keyPairGenerator.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Can't init Key Pair");
		}
	}
	
	public static PublicKey GetPublicKey() {
		return keyPair.getPublic(); //lay khoa Public
	}
	
	public static String PublicKeyToString() {
	        try {
		        PublicKey publicKey = Encode.GetPublicKey();

		        // Chuyển đổi PublicKey thành một mảng byte
		        byte[] publicKeyBytes = publicKey.getEncoded();

		        // Encode mảng byte thành chuỗi sử dụng Base64
		        String publicKeyString = Base64.getEncoder().encodeToString(publicKeyBytes);

		        // In chuỗi PublicKey
		        return publicKeyString;
		        
			} catch (Exception e) {
				// TODO: handle exception
			}
	        return "false";
	    }
	
	/* ToCrypto (mahoa) : String Password -> bytes Password -> EncryptedBytes ->  StringBase64 -> Caesar */
	public static String ToCrypto(String PlainPassword,String PublicKey) {
		try {
			String publicKeyString =PublicKey ;
			byte[] publicBytes = Base64.getDecoder().decode(publicKeyString);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			
			byte[] BytePassword = PlainPassword.getBytes();
			PublicKey publicKey = keyFactory.generatePublic(keySpec); //lay khoa Public
			//tao doi tuong su dung khoa
			Cipher cipherEncrypted = Cipher.getInstance("RSA"); //
			//che do ma hoa (hoac gia ma)
			cipherEncrypted.init(Cipher.ENCRYPT_MODE, publicKey);
			//MA HOA LUON O DANG BYTE
			byte[] encryptedBytePassword = cipherEncrypted.doFinal(BytePassword);
			
			String StringBase64 = Base64.getEncoder().encodeToString(encryptedBytePassword);
			String Caesar = CaesarEncode(StringBase64);
			System.out.println("data has encrypted : " + Caesar);
			return Caesar;
		//	byte[] decryptedHashByte = cipherDecrypt.doFinal();
		}catch(Exception e) {
			System.out.println("can't encrypt");
		}
		return "false";
	}
	/* FromCrypto (giai ma) : Caesar -> StringBase64 -> EncryptedBytes -> Bytes Password -> String Passord */
	public static String FromCrypto(String Caesar) {
		try {
			PrivateKey privateKey = keyPair.getPrivate(); // lay khoa Private 
			//tao doi tuong su dung khoa
			Cipher cipherDecrypted = Cipher.getInstance("RSA");
			System.out.println("here");
			cipherDecrypted.init(Cipher.DECRYPT_MODE,privateKey);
			System.out.println("here");
			//giai ma caesar 
			String DecodeCaesar = CaesarDecode(Caesar);
			System.out.println("here" + DecodeCaesar);
			//giai ma base 64
			byte[] DecodeBase64 = Base64.getDecoder().decode(DecodeCaesar);
			System.out.println("here" );
			//giai ma bang private key
			
			byte[] decryptedBytePassword = cipherDecrypted.doFinal(DecodeBase64);
			//dua ve chuoi
			System.out.println("here");
			String Password123 = new String(decryptedBytePassword);
			System.out.println("here");
			System.out.println(Password123);
			//bam thanh Byte
			return Password123;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
/************************CAESAR********************************/
	
	public static String CaesarEncode(String s) {
		String re = "";
		for(int i=0;i<s.length();i++)
		re+=  (char) (s.charAt(i) + 4);
		return re;
	}
	public static String CaesarDecode(String s) {
		String re = "";
		for(int i=0;i<s.length();i++)
		re+=  (char) (s.charAt(i) - 4);
		return re;
	}
/************************CAESAR********************************/
}
