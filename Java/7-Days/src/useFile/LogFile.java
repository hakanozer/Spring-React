package useFile;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.*;

public class LogFile {

    // dosya adı ve uzantısı
    String path = "";
    String folderPath = "files";
    final File file;
    public LogFile( String path ) {
        File folderFile = new File(folderPath);
        if ( !folderFile.isDirectory() ) { // klasör kontrol
            folderFile.mkdir(); // klasör oluşturma
        }
        this.path = path+".txt";
        file = new File(folderPath+"/"+this.path);
    }

    // dosya oluşturma
    public void createFile() {
        try {
            if ( !file.exists() ) { // dosya daha önceden var mı ?
                file.createNewFile(); // dosya oluşturma
            }
        }catch (Exception ex) {
            System.err.println("createFile Error : " + ex);
        }
    }

    // dosya silme
    public void deleteFile() {
        try {
            if ( file.exists() ) {
                file.delete();
            }
        }catch (Exception ex) {
            System.err.println("deleteFile Error : " + ex);
        }
    }

    // tüm dosyaları bul ve sil
    public void allFileDelete() {
        File folders = new File(folderPath);
        File[] files = folders.listFiles();
        for( File item : files ) {
            String ex = item.getAbsolutePath();
            if ( ex.toLowerCase().endsWith(".txt") ) {
                item.delete();
            }
        }
    }

    // dosyaya data yazma
    public void write( String ...data ) {
        List<String> lsx = Arrays.asList(data);
        Set<String> set = new HashSet<>(lsx);
        try {
            // Dosya yazma nesnesi FileWriter'dır
            FileWriter writer = new FileWriter(file, true);
            List<String> ls = read();
            for ( String item : set ) {
                if ( !ls.contains(item) ) {
                    writer.append(item + System.lineSeparator());
                }
            }
            writer.close(); // close yöntemi kaydet ve kapat
        }catch (Exception ex) {
            System.err.println("write Error : " + ex);
        }
    }

    // Dosyadan data okuma
    public List<String> read() {
        List<String> ls = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while( scanner.hasNext() ) {
                String item = scanner.next();
                ls.add( item );
            }
            scanner.close();
        }catch (Exception ex) {
            System.err.println("read Error : " + ex);
        }
        return ls;
    }



}
