package com.giuseviet.vidu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.giuseviet.vidu.R;
import com.giuseviet.vidu.model.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    Context context;

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    ArrayList<User> list;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_contact,null);

        ImageView avatar=row.findViewById(R.id.img_avatar);
        TextView tvName=row.findViewById(R.id.tv_contact_name);
        TextView tvGender=row.findViewById(R.id.tv_ct_gender);
        TextView tvphone=row.findViewById(R.id.tv_ct_number);
        TextView tvEmail=row.findViewById(R.id.tv_ct_email);
        TextView tvAddress=row.findViewById(R.id.tv_ct_address);

        //Cài đặt giá trị
        User user=list.get(position);
        tvName.setText(user.getmName());
        tvGender.setText(user.getmGender());
        tvphone.setText(user.getmPhoneNumber());
        tvEmail.setText(user.getmEmail());
        tvAddress.setText(user.getmAddress());
        if(user.getmGender().toLowerCase().equals("nam")){
            avatar.setBackgroundResource(R.drawable.nam);
        }else{
            avatar.setBackgroundResource(R.drawable.nu);
        }
        return row;
    }
}
