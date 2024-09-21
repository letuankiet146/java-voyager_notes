package com.example.server;

import com.example.util.MyClient;

import java.io.*;

public class ServerMainClass {

    public static void main(String[] args) {
        System.setProperty("password", "difficult_password@BC");
        NormalObject normalObject = new NormalObject("A_object");
        byte[] objByteSrc = serialize(normalObject);
        NormalObject aObject = (NormalObject) deserialize(objByteSrc);
        System.out.println(aObject);
        System.out.println("\nAttacking....");
        byte[] maliciousBytes = MyClient.send();
        NormalObject unknown= (NormalObject)deserialize(maliciousBytes);
        System.out.println(unknown);
    }

    private static byte[] serialize(final Object obj) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(obj);
            out.flush();
            return bos.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Object deserialize(byte[] bytes) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        try (ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
