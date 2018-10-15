package com.gameconnect3.ujjwal.firebasedemo.ThirdAcitivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.gameconnect3.ujjwal.firebasedemo.R;

public class Upper_Log extends Fragment{

    String[] message_id={"Hello world!!!!","hi, my name is adam.","Namaste, konichiwa minna san",
                        "Arigatiogozimash"};
    String[] date_id={"2015/3/31","2012/3/31","2035/3/31","2055/3/31"};

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.log_listview,null);
        listView=view.findViewById(R.id.log);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

        return view;
    }

    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return message_id.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1=getLayoutInflater().inflate(R.layout.logcontainer,null);
            TextView date=view1.findViewById(R.id.date);
            TextView message=view1.findViewById(R.id.message);

            date.setText(date_id[i]);
            message.setText(message_id[i]);
            return view1;
        }
    }
}
