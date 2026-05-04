import javax.swing.*;
import java.awt.event.*;

public class FormGUI extends JFrame {

    JTextField nama, ttl, noDaftar, noTelp, email;
    JTextArea alamat;
    JButton submit;

    public FormGUI() {
        setTitle("Form Daftar Ulang Mahasiswa");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        addLabel("Nama Lengkap", 20);
        nama = addTextField(140, 20);

        addLabel("Tanggal Lahir", 60);
        ttl = addTextField(140, 60);

        addLabel("Nomor Pendaftaran", 100);
        noDaftar = addTextField(140, 100);

        addLabel("No. Telp", 140);
        noTelp = addTextField(140, 140);

        addLabel("Alamat", 180);
        alamat = new JTextArea();
        alamat.setBounds(140, 180, 200, 50);
        add(alamat);

        addLabel("E-mail", 250);
        email = addTextField(140, 250);

        submit = new JButton("Submit");
        submit.setBounds(140, 300, 100, 30);
        add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (!validasi()) return;

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Apakah data sudah benar?",
                        "Konfirmasi",
                        JOptionPane.OK_CANCEL_OPTION);

                if (confirm == JOptionPane.OK_OPTION) {
                    Mahasiswa mhs = new Mahasiswa(
                            nama.getText(),
                            ttl.getText(),
                            noDaftar.getText(),
                            noTelp.getText(),
                            alamat.getText(),
                            email.getText()
                    );

                    new HasilFrame(mhs);
                }
            }
        });
    }

    boolean validasi() {
        if (nama.getText().isEmpty() || ttl.getText().isEmpty() ||
            noDaftar.getText().isEmpty() || noTelp.getText().isEmpty() ||
            alamat.getText().isEmpty() || email.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Semua field wajib diisi!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    void addLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(20, y, 120, 25);
        add(label);
    }

    JTextField addTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 200, 25);
        add(tf);
        return tf;
    }
}
