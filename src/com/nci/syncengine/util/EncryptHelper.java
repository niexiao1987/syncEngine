//package com.nci.syncengine.util;
//
//import java.io.IOException;
//import java.security.InvalidKeyException;
//import java.security.Key;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//import java.security.Security;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//
///**
// * <p>
// * Title: 
// * </p>
// * <p>
// * Description:
// * </p>
// * <p>
// * Copyright: Copyright (c) 2004
// * </p>
// * <p>
// * Company:
// * </p>
// * 
// * @author yaoxj
// * @version 1.0
// */
//public final class EncryptHelper {
//	/**
//	 * 使用md5进行加密（不可逆）
//	 * @param value
//	 * @return
//	 * @throws Exception
//	 */
//	public static String encryptMD5(String value) throws Exception {
//		String result = "";
//		if (value == null) {
//			value = "";
//		}
//		try {
//			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//			messageDigest.update(value.getBytes());
//			result = byte2hex(messageDigest.digest());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception(e.getMessage());
//		}
//		return result;
//	}
//
//	/*
//	 * ������ת�ַ�
//	 */
//	public static String byte2hex(byte[] bytes) {
//		String result = "";
//		String stmp = "";
//		for (int n = 0; n < bytes.length; n++) {
//			stmp = (java.lang.Integer.toHexString(bytes[n] & 0xFF));
//			if (stmp.length() == 1)
//				result = result + "0" + stmp;
//			else
//				result = result + stmp;
//
//		}
//		return result.toUpperCase();
//	}
//	
//	/**
//	 * 返回对称密钥
//	 * @return
//	 * @throws IOException 
//	 */
//	private static Key getkey() throws IOException {
//		String encKey = "tyX+dyNeTgKFXZw1toui5w==";
//		BASE64Decoder decode = new BASE64Decoder();
//        SecretKey keySpec = new SecretKeySpec(decode.decodeBuffer(encKey), 
//        		"1.2.840.113549.3.4");
//		return keySpec;
//	}
//	
//	/**
//	 * 加密
//     * @param k 密钥
//     * @param str 被加密字符串
//	 * @param ari 加密算法
//	 * return 加密后的字节数组
//     */
//	public static byte[] encrypt(SecretKey k,byte[] prib,String ari,String provider){
//		Security.addProvider(new BouncyCastleProvider());
//		Cipher c = null;
//		try {
//			c = Cipher.getInstance(ari, provider);
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchProviderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			c.init(Cipher.ENCRYPT_MODE, k);
//		} catch (InvalidKeyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		byte[] encode = null;
//		try {
//			encode = c.doFinal(prib);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return encode;
//	} 
//	/**
//	 * 解密
//     * @param k 密钥
//     * @param b 被解密字节数组
//	 * @param ari 加密算法
//	 * return 解密后字节数组
//     */
//	public static byte[] decrypt(SecretKey k,byte[] b,String ari,String provider){
//		Security.addProvider(new BouncyCastleProvider());
//		Cipher c = null;
//		try {
//			c = Cipher.getInstance(ari, provider);
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchProviderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			c.init(Cipher.DECRYPT_MODE, k);
//		} catch (InvalidKeyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		byte[] decode = null;
//		try {
//			decode = c.doFinal(b);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return decode;
//	}
//	/**
//	 * 加密密码
//	 * @param a 密码原文
//	 * @return
//	 */
//	public static String encryptPwd(String a){
//		byte[] bEnpriv = null;
//		try {
//			bEnpriv = encrypt((SecretKey)getkey(), a.getBytes(),
//					"1.2.840.113549.3.4","BC");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new BASE64Encoder().encode(bEnpriv);
//	}
//	/**
//	 * 解密密码
//	 * @param a 密码密文
//	 * @return
//	 */
//	public static String decryptPwd(String a){
//		byte[] bEnpriv = null;
//		try {
//			bEnpriv = new BASE64Decoder().decodeBuffer(a);
//			bEnpriv = decrypt((SecretKey)getkey(), bEnpriv,
//					"1.2.840.113549.3.4","BC");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new String(bEnpriv);
//	}
//	
//	
//	public static void main(String[] argus) throws Exception {
////		String s = "   ";
////		System.out.println(encryptPwd(s));
////		System.out.println("加密后："+s);
//		System.out.println("解密后："+decryptPwd("SlwKVqZ4"));//njl@xf  SlwKVqZ45V00
//		
////		String s="T1oNV6R75FxhDQ==";//lq
////		String s="AhtYDPEnvFU7Tg0=";
////		System.out.println(decryptPwd(s));
//		
////		System.out.println(encryptMD5("yy1yy1"));
//	}
//}
