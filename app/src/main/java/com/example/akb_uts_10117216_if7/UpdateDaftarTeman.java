package com.example.akb_uts_10117216_if7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akb_uts_10117216_if7.R;
import com.example.akb_uts_10117216_if7.database.DbHelper;
import com.example.akb_uts_10117216_if7.view.NotificationsFragment;

public class UpdateDaftarTeman extends AppCompatActivity {

    private String nim,nama,kelas,telp,email,sosmed;
    DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_daftar);

        helper = new DbHelper(this);
        nim = getIntent().getStringExtra("nim");
        showUpdate(nim);
    }


    private void showUpdate(String vNim){
        String valNim = "";
        String valNama = "";
        String valKelas = "";
        String valTelp = "";
        String valEmail = "";
        String valSosmed = "";

        Cursor data = helper.getData(vNim);
        while (data.moveToNext()) {
            valNim = data.getString(0);
            valNama = data.getString(1);
            valKelas = data.getString(2);
            valTelp = data.getString(3);
            valEmail = data.getString(4);
            valSosmed = data.getString(5);
        }
        Log.d("TAG", "showUpdate: "+valNama);

        final TextView nim = findViewById(R.id.edit_text_nim_ubah);
        final EditText nama = findViewById(R.id.edit_text_nama_ubah);
        final EditText kelas = findViewById(R.id.edit_text_kelas_ubah);
        final EditText telp = findViewById(R.id.edit_text_telp_ubah);
        final EditText email = findViewById(R.id.edit_text_email_ubah);
        final EditText sosmed = findViewById(R.id.edit_text_sosmed_ubah);
        Button btnUbah = findViewById(R.id.btn_form_ubah);
        Button btnHapus = findViewById(R.id.btn_form_hapus);

        nim.setText(valNim);
        nama.setText(valNama);
        kelas.setText(valKelas);
        telp.setText(valTelp);
        email.setText(valEmail);
        sosmed.setText(valSosmed);

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    helper.updateData(nim.getText().toString(), nama.getText().toString(), kelas.getText().toString(), telp.getText().toString(), email.getText().toString(), sosmed.getText().toString());
                    Toast.makeText(UpdateDaftarTeman.this, "Berhasil di Ubah", Toast.LENGTH_SHORT).show();
                    FragmentManager f = getSupportFragmentManager();
                    NotificationsFragment notificationsFragment = new NotificationsFragment();
                    f.beginTransaction().add(R.id.update_layout, notificationsFragment).commit();
                    finish();
                }catch (Exception e){
                    Toast.makeText(UpdateDaftarTeman.this, "Gagal di Ubah", Toast.LENGTH_SHORT).show();
                    Log.e("Update Error ", e.getMessage() );
                }
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    helper.deleteData(nim.getText().toString());
                    Toast.makeText(UpdateDaftarTeman.this, "Berhasil di hapus", Toast.LENGTH_SHORT).show();
                    FragmentManager f = getSupportFragmentManager();
                    NotificationsFragment notificationsFragment = new NotificationsFragment();
                    f.beginTransaction().add(R.id.update_layout, notificationsFragment).commit();
                    finish();
                }catch (Exception e){
                    Toast.makeText(UpdateDaftarTeman.this, "Gagal di hapus", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}


// 11 mei 2020
// 10117216 - Adi Prayoga - IF7