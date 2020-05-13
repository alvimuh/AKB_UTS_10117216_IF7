package com.example.akb_uts_10117216_if7.view;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.akb_uts_10117216_if7.DaftarTemanAdapter;
import com.example.akb_uts_10117216_if7.DaftarTemanModel;
import com.example.akb_uts_10117216_if7.R;
import com.example.akb_uts_10117216_if7.AddDaftarTeman;
import com.example.akb_uts_10117216_if7.UpdateDaftarTeman;
import com.example.akb_uts_10117216_if7.database.DbHelper;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private Button btn_tambah;
    DbHelper helper;
    ListView mListView;
    DaftarTemanAdapter daftarTemanAdapter = null;
    ArrayList<DaftarTemanModel> mList;


    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        mListView = root.findViewById(R.id.listView);
        mList = new ArrayList<>();
        daftarTemanAdapter = new DaftarTemanAdapter(getActivity(), R.layout.card_item, mList);
        mListView.setAdapter(daftarTemanAdapter);
        helper = new DbHelper(getActivity());

        updateRecordList();
        if(mList.size() == 0){
            Toast.makeText(getActivity(), "Silahkan Tambahkan Teman", Toast.LENGTH_SHORT).show();
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = helper.getAllData();
                ArrayList<Integer> arrNim = new ArrayList<Integer>();
                while (cursor.moveToNext()){ arrNim.add(cursor.getInt(0)); }
                Intent intent = new Intent(getActivity(), UpdateDaftarTeman.class);
                intent.putExtra("nim", arrNim.get(position).toString());
                startActivity(intent);
            }
        });


        btn_tambah = root.findViewById(R.id.btn_tambah);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddDaftarTeman.class);
                startActivity(intent);
            }
        });

        return root;
    }

    public void updateRecordList(){
        Cursor data = helper.getAllData();
        mList.clear();
        while (data.moveToNext()){
            String nim = data.getString(0);
            String nama = data.getString(1);
            String kelas = data.getString(2);
            String telp = data.getString(3);
            String email = data.getString(4);
            String sosmed = data.getString(5);
            mList.add(new DaftarTemanModel(nim, nama, kelas, telp, email, sosmed));
        }
        daftarTemanAdapter.notifyDataSetChanged();
    }

}
