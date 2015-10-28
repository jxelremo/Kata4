package kata4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Kata4 {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\usuario\\Documents";
        File file = new File (path);
        
        String from = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg";
        String to = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse (1).jpg";

        BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(from)));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(to)));
        Date date = new Date();
        byte[] buffer = new byte[1024];
        
        while (true){
            int read = input.read(buffer);
            if (read < 0) break;
            output.write(buffer);
        }
        
        System.out.println(new Date().getTime()-date.getTime()+"msg");
        input.close();
        output.flush();
        output.close();
        
        //print(file.listFiles(),"");
}

    private static void print(File[] listFiles, String indent) {
        if (listFiles == null) return;
        for (File listFile : listFiles) {
            System.out.println(indent+(listFile.isDirectory()?"+":" ")+listFile.getName());
            if(!listFile.isDirectory() || listFile.isHidden()) continue;
            print(listFile.listFiles()," ");
        }
    }
}
