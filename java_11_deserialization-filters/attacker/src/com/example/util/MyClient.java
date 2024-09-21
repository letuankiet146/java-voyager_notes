package com.example.util;

import com.example.obj.MaliciousObject;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class MyClient {
    public static byte[] send() {
        MaliciousObject object = new MaliciousObject();
        return serialize(object);
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
}
