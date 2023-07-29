public class CertificateReaderAlfa {
    public static void main(String[] args) {

        CertificateReader cr = new CertificateReader();
        CertificateGUI cg = new CertificateGUI();
        CertificateFormatUtil cfu = new CertificateFormatUtil();
        CertificateInfoUtil ciu = new CertificateInfoUtil();
        CertificateViewer cv = new CertificateViewer();

        cg.createGUI();
        cg.setVisible(true);

    }
}
