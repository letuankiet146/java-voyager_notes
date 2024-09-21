package com.example.obj;

import java.io.*;

public class MaliciousObject  implements Serializable {
    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("Execute malicious code..... ");
        System.out.println("****** Sensitive Information : ");
        System.out.println(System.getProperties());
        System.out.println(System.getenv());
    }
}
