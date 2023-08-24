package storage;

import java.io.File;

public class CertEntry {

    private String alias;

    private File file;

    public CertEntry(String alias, File file) {
        this.alias = alias;
        this.file = file;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
