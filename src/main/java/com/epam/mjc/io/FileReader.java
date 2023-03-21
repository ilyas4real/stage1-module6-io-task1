package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {
    BufferedReader inputStream = null;


    public Profile getDataFromFile(File file) throws IOException {
        BufferedReader inputStream = null;
        Map<String, String> map = new HashMap<>();

        try {
            inputStream = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = inputStream.readLine()) != null) {
                String[] k = line.split(": ");
                String key = k[0];
                String value = k[1];
                map.put(key, value);
            }


        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            return new Profile(map.get("Name"), Integer.parseInt(map.get("Age")), map.get("Email"), Long.parseLong(map.get("Phone")));
        }
    }
}
