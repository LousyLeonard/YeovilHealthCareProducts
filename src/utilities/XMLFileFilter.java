package utilities;
import java.io.File;
import java.io.FilenameFilter;

public class XMLFileFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".xml".toLowerCase());
    }
}