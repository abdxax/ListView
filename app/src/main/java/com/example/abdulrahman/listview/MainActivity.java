package com.example.abdulrahman.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList <AdapterItem> a=new ArrayList<AdapterItem>();
        a.add(new AdapterItem(5,"test","test the view "));
        a.add(new AdapterItem(1,"test","test the view "));
        a.add(new AdapterItem(3,"test","test the view "));
        a.add(new AdapterItem(4,"test","test the view "));

        coustem c=new coustem(a);
        GridView listView=(GridView) findViewById(R.id.list);
        listView.setAdapter(c);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),a.get(position).id+" ",Toast.LENGTH_LONG).show();
            }
        });
    }

    private class coustem extends BaseAdapter {

        ArrayList<AdapterItem> adapterItems;

        public coustem(ArrayList<AdapterItem> adapterItems) {
            this.adapterItems = adapterItems;
        }

        @Override
        public int getCount() {
            return adapterItems.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater=getLayoutInflater();
            View view=layoutInflater.inflate(R.layout.layout_taickt, null);

            AdapterItem ad=adapterItems.get(position);

            TextView id=(TextView) view.findViewById(R.id.ids);
            TextView title=(TextView) view.findViewById(R.id.title);
            TextView des=(TextView) view.findViewById(R.id.des);

            id.setText(ad.id+"");
            title.setText(ad.title);
            des.setText(ad.des);

           /* id.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"the postion is "+position,Toast.LENGTH_LONG).show();
                }
            });
            */
            return view;
        }
    }
}
