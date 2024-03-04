
package com.jbrod.ide_sql.app.CsvDriver;

import java.io.*;

public class FileManager {
    
    public String readFile(String path) {
        StringBuilder content  = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = br.readLine()) != null) {
                 content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public String getFileName(String path){
        File file = new File(path);
        return file.getName();
    }
    
    public void writeFile(String path, String content) {
        try (FileWriter writer = new FileWriter(path);
             BufferedWriter bw = new BufferedWriter(writer)) {
             bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
