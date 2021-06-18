package cn.pinkhorizon.commons.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author ybf
 */
public class RsaUtils {
    /**
     * 算法
     */
    private static final String DEFAULT_ALGORITHM = "RSA";
    /**
     * key大小
     */
    private static final Integer DEFAULT_KEY_SIZE = 4096;

    /**
     * 获取公钥对象
     * publicKeyFilePath 公钥文件存放路径
     */
    public static PublicKey getPublicKey(String publicKeyFilePath) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(DEFAULT_ALGORITHM);
        byte[] bytes = readFile(publicKeyFilePath);
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bytes);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        return publicKey;
    }

    /**
     * 获取私钥对象
     * privateKeyFilePath 私钥文件存放路径
     */
    public static PrivateKey getPrivateKey(String privateKeyFilePath) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(DEFAULT_ALGORITHM);
        byte[] bytes = readFile(privateKeyFilePath);
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(bytes);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        return privateKey;
    }

    private static byte[] readFile(String filePath) throws Exception {
        return Files.readAllBytes(new File(filePath).toPath());
    }

    /**
     * 根据密文，生存rsa公钥和私钥，并写入指定文件
     * publicKeyFilePath  公钥文件路径,例如：D:\rsa_key\id_key_rsa_public
     * privateKeyFilePath 私钥文件路径,例如：D:\rsa_key\id_key_rsa
     */
    private static void generateKey(String publicKeyFilePath, String privateKeyFilePath) throws Exception {
        //创建生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(DEFAULT_ALGORITHM);
        //secret 生成密钥的盐 随机取一个即可
        String salt = UUID.randomUUID().toString();
        keyPairGenerator.initialize(DEFAULT_KEY_SIZE, new SecureRandom(salt.getBytes()));
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        //获取公钥并写出
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        writeFile(publicKeyFilePath, publicKeyBytes);
        //获取私钥并写出
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        writeFile(privateKeyFilePath, privateKeyBytes);
    }

    private static void writeFile(String destPath, byte[] bytes) throws IOException {
        File file = new File(destPath);
        if (!file.exists()) {
            file.createNewFile();
        }
        Files.write(file.toPath(), bytes);
    }

    public static String getStrPrivateKey(String classPath, String param) {
        FileInputStream inputStream = null;
        try {
            //1、JKS文件的真实路径
            String path = RsaUtils.class.getClassLoader().getResource(classPath).getPath();
            inputStream = new FileInputStream(path);
            //2、获取KeyStore实例
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(inputStream, param.toCharArray());
            //3.获取JKS证书别名
            String name = null;
            final Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                String alias = aliases.nextElement();
                if (keyStore.isKeyEntry(alias)) {
                    name = alias;
                }
            }
            //4、获取私钥实例
            final PrivateKey privateKey = (PrivateKey) keyStore.getKey(name, param.toCharArray());
            //5、获取私钥字符串
            final String strPrivateKey = new String(Base64.getEncoder().encode(privateKey.getEncoded()));
            //6、返回结果
            return strPrivateKey;
        } catch (Exception e) {
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}