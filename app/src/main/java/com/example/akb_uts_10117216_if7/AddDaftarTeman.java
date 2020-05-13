package com.example.akb_uts_10117216_if7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.akb_uts_10117216_if7.R;
import com.example.akb_uts_10117216_if7.database.DbHelper;
import com.example.akb_uts_10117216_if7.view.NotificationsFragment;

public class AddDaftarTeman extends AppCompatActivity {

    private EditText pNIMEt,pNamaEt, pKelasEt,pEmailEt, pSosmedEt, pTelpEt;
    Button btAdd;
    private String nim,nama,kelas,telp,email,sosmed;
    private DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_daftar);

        pNIMEt = findViewById(R.id.edit_text_nim);
        pNamaEt = findViewById(R.id.edit_text_nama);
        pKelasEt = findViewById(R.id.edit_text_kelas);
        pTelpEt = findViewById(R.id.edit_text_telp);
        pEmailEt = findViewById(R.id.edit_text_email);
        pSosmedEt = findViewById(R.id.edit_text_sosmed);

        btAdd = findViewById(R.id.btnSimpan);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void getData() {
        helper = new DbHelper(this);
        nim = pNIMEt.getText().toString();
        nama = pNamaEt.getText().toString();
        kelas = pKelasEt.getText().toString();
        telp = pTelpEt.getText().toString();
        email = pEmailEt.getText().toString();
        sosmed = pSosmedEt.getText().toString();
        Boolean tambah= false;

        if(!nim.isEmpty()){ tambah = helper.insertData(nim, nama, kelas, telp, email, sosmed); }

        if(tambah){
            finish();
            FragmentManager f = getSupportFragmentManager();
            NotificationsFragment notificationsFragment = new NotificationsFragment();
            f.beginTransaction().replace(R.id.tambah_layout, notificationsFragment).commit();
            Toast.makeText(this, "Berhasil Menambahkan", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Gagal Menambahkan", Toast.LENGTH_LONG).show();
        }
    }

}

// 09 mei 2020
// 10117216 - Adi Prayoga - IF7