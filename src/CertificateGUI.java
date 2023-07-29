/*TODO Класс для создания графического интерфейса программы.
   Отвечает за создание всех компонентов GUI, установку обработчиков событий и обновление интерфейса при необходимости.
   Взаимодействует с CertificateManager, чтобы получить список сертификатов и информацию о выбранном сертификате.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CertificateGUI extends JFrame {

    JList<String> lstAliases = null;
    JTextField txtFileName = null;
    JTextArea taCertificate = null;
    CertificateReader cr;
    final int LIST_size = 140;

    public JPanel createCtrl() {
        JPanel pnlControls = new JPanel();

        pnlControls.setLayout(new FlowLayout(FlowLayout.CENTER));

        pnlControls.setSize(480, 40);

        txtFileName = new JTextField();
        txtFileName.setMinimumSize(new Dimension(6, 100));
        txtFileName.setPreferredSize(new Dimension(460, 25));
        txtFileName.setText("Выберите хранилище");

        JButton btnBrowseStore = new JButton();
        btnBrowseStore.setText("Хранилище");
        btnBrowseStore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cr.loadKeyStore();
            }
        });

        pnlControls.add(txtFileName, null);
        pnlControls.add(btnBrowseStore, null);

        return pnlControls;
    }

    public JSplitPane createGUI() {
        lstAliases = new JList<String>();
        taCertificate = new JTextArea(18, 30);
        taCertificate.setMargin(new Insets(5, 5, 5, 5));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(new JScrollPane(lstAliases));
        splitPane.setRightComponent(new JScrollPane(taCertificate));
        splitPane.setDividerSize(8);
        splitPane.setDividerLocation(LIST_size);

        lstAliases.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                cr.showCertificate(lstAliases.getSelectedValue());
                lstAliases.getSelectionModel().clearSelection();
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
        return splitPane;
    }
}
