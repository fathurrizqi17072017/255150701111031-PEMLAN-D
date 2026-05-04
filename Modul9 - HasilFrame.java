import javax.swing.*;

public class HasilFrame extends JFrame {

    public HasilFrame(Mahasiswa mhs) {
        setTitle("Data Mahasiswa");
        setSize(350, 300);
        setLocationRelativeTo(null);

        JTextArea hasil = new JTextArea();
        hasil.setEditable(false);
        hasil.setText(mhs.getData());

        add(new JScrollPane(hasil));
        setVisible(true);
    }
}
