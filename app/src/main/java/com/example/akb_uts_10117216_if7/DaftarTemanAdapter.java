package com.example.akb_uts_10117216_if7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.akb_uts_10117216_if7.R;

import java.util.ArrayList;

public class DaftarTemanAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<DaftarTemanModel> recordList;

    public DaftarTemanAdapter(Context context, int layout, ArrayList<DaftarTemanModel> recordList){
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int position) {
        return recordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView tvNim, tvNama, tvKelas, tvTelp, tvEmail, tvSosmed;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.tvNim = row.findViewById(R.id.tv_nim);
            holder.tvNama = row.findViewById(R.id.tv_nama);
            holder.tvKelas = row.findViewById(R.id.tv_kelas);
            holder.tvTelp = row.findViewById(R.id.tv_telp);
            holder.tvEmail = row.findViewById(R.id.tv_email);
            holder.tvSosmed = row.findViewById(R.id.tv_sosmed);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }

        DaftarTemanModel daftarTemanModel = recordList.get(position);
        holder.tvNim.setText(daftarTemanModel.getNim());
        holder.tvNama.setText(daftarTemanModel.getNama());
        holder.tvKelas.setText(daftarTemanModel.getKelas());
        holder.tvTelp.setText(daftarTemanModel.getTelp());
        holder.tvEmail.setText(daftarTemanModel.getEmail());
        holder.tvSosmed.setText(daftarTemanModel.getSosmed());

        return row;
    }
}

// 12 mei 2020
// 10117216 - Adi Prayoga - IF7
