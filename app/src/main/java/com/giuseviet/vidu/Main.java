package com.giuseviet.vidu;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import com.giuseviet.vidu.adapter.UserAdapter;
import com.giuseviet.vidu.data.Database;
import com.giuseviet.vidu.model.User;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    final String DATABASE_NAME="danhba.sqlite";
    SQLiteDatabase database;

    ListView listView;
    ArrayList<User>list;
    UserAdapter adapder;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodien);

        addControl();
        readData();
    }

    private void addControl() {
        listView=findViewById(R.id.lv_item);
        list=new ArrayList<>();
        adapder=new UserAdapter(this,list);
        listView.setAdapter(adapder);
    }

    private void readData(){
        database= Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM User ",null);
        list.clear();
        for (int i=0; i<cursor.getCount(); i++){
            cursor.moveToPosition(i);
            String name=cursor.getString(1);
            String gender=cursor.getString(2);
            String phone=cursor.getString(3);
            String email=cursor.getString(4);
            String address=cursor.getString(5);
            list.add(new User(name,gender,phone,email,address));
        }
        adapder.notifyDataSetInvalidated();
    }
}
