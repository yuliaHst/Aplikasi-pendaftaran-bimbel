package id.sch.smktelkom_mlg.tugas01.xiirpl4039.bimbel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ednama;
    EditText edalamat;
    EditText ednotlp;
    Spinner spkelas;
    RadioGroup rgjk;
    CheckBox cbbsk, cbps, cbfo, cbpr, cbtf;
    TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ednama = (EditText) findViewById(R.id.editTextnama);
        edalamat = (EditText) findViewById(R.id.editTextalmt);
        ednotlp = (EditText) findViewById(R.id.editTexttlp);
        spkelas = (Spinner) findViewById(R.id.spinnerkelas);
        rgjk = (RadioGroup) findViewById(R.id.radiogroupjk);
        cbbsk = (CheckBox) findViewById(R.id.checkBoxbskt);
        cbps = (CheckBox) findViewById(R.id.checkBoxps);
        cbfo = (CheckBox) findViewById(R.id.checkBoxfo);
        cbpr = (CheckBox) findViewById(R.id.checkBoxpr);
        cbtf = (CheckBox) findViewById(R.id.checkBoxtfsr);
        tvhasil = (TextView) findViewById(R.id.textViewhasil);
        findViewById(R.id.buttonok).setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                               doClick();

                                                           }
                                                       }
        );
    }

    private void doClick() {
        if (isValid()) {
            String nama = ednama.getText().toString();
            String alamat = edalamat.getText().toString();
            String notlp = ednotlp.getText().toString();
            StringBuilder builder = new StringBuilder();
            String hasil = null;
            if (rgjk.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rgjk.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            if (hasil == null) {
                tvhasil.setText("Anda belum mengisi jenis kelamin");
            } else {
                String bimbel = "\t Bimbigan belajar yang dipilih : \t\n";
                int startlen = bimbel.length();
                if (cbbsk.isChecked()) bimbel += "\t - " + cbbsk.getText() + "\n";
                if (cbps.isChecked()) bimbel += "\t - " + cbps.getText() + "\n";
                if (cbfo.isChecked()) bimbel += "\t - " + cbfo.getText() + "\n";
                if (cbpr.isChecked()) bimbel += "\t - " + cbpr.getText() + "\n";
                if (cbtf.isChecked()) bimbel += "\t - " + cbtf.getText() + "\n";
                if (bimbel.length() == startlen) {
                    tvhasil.setText("Anda belum memilih mata pelajaran");
                } else {
                    builder.append("Nama : " + nama + "\n");
                    builder.append("Alamat :" + alamat + "\n");
                    builder.append("No.Tlp :" + notlp + "\n");
                    builder.append("Kelas : ");
                    builder.append(spkelas.getSelectedItem().toString() + "\n");
                    builder.append("Jenis kelamin : " + hasil + "\n");
                    builder.append(bimbel + "\n");
                    tvhasil.setText(builder);
                }
            }
        }
    }


    private boolean isValid() {
        boolean valid = true;

        String nama = ednama.getText().toString();

        if (nama.isEmpty()) {
            ednama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            ednama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            ednama.setError(null);
        }
        return valid;
    }
}
