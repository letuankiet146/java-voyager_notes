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
        try{
            Object unknown= deserialize(maliciousBytes);
            System.out.println(unknown);
        } catch (Exception e) {
            System.err.println("Deny deserialization process due to untrust.");
        }
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

        try (ObjectInputStream in = new ObjectInputStream(bis)) {
            ObjectInputFilter customFilter =(info)->{
                if (info.serialClass() != null) {
                    String className = info.serialClass().getName();
                    // Just make sure filter will deny malicious object rom com.example.obj, then allow other classes.
                    if (className.contains("obj")) {
                        return ObjectInputFilter.Status.REJECTED;
                    }
                }
                return ObjectInputFilter.Status.ALLOWED;
            };
            in.setObjectInputFilter(customFilter);
            return in.readObject();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
