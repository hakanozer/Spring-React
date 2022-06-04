package useFile;

import java.util.List;

public class MainFile {
    public static void main(String[] args) {

        LogFile logFile = new LogFile("sample");
        //logFile.createFile();
        //logFile.deleteFile();
        //logFile.allFileDelete();
        logFile.write( "Kocaeli", "İzmir", "Kocaeli" );
        //List<String> ls = logFile.read();
        //System.out.println( ls );
    }
}
