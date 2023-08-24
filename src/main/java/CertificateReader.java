import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.bouncycastle.cert.X509CertificateHolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.*;


public class CertificateReader {

    public static String openCertificate(ListView<String> certificateList, Stage primaryStage) {
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Создание сертификата");
        String certificateDetails = "";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите сертификат");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Certificate Files", "*.cer"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null && selectedFile.isFile() && selectedFile.getName().endsWith(".cer")) {
            String certificateName = selectedFile.getName().replace(".cer", "");
            certificateList.getItems().add(certificateName);

            try (FileInputStream certificateInputStream = new FileInputStream(selectedFile)) {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(certificateInputStream);

                certificateDetails = "Субъект: " + certificate.getSubjectDN() + "\n" +
                        "Выдан: " + certificate.getIssuerDN() + "\n" +
                        "Серийный номер: " + certificate.getSerialNumber() + "\n" +
                        "Срок действия с " + certificate.getNotBefore() + " до " + certificate.getNotAfter() + "\n" +
                        // Другие детали, которые вы хотите отобразить
                        "Открытый ключ: " + certificate.getPublicKey() + "\n";

            } catch (IOException | CertificateException e) {
                e.printStackTrace();
            }
        }
        return certificateDetails;
    }
}
