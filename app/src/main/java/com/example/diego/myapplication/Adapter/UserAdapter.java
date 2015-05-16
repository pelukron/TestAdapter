package com.example.diego.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.diego.myapplication.Model.User;
import com.example.diego.myapplication.R;

import java.util.ArrayList;

/**
 * Created by diego on 5/16/15.
 */
public class UserAdapter extends BaseAdapter {

    ArrayList<User> item;
    LayoutInflater inflater;

    public UserAdapter(Context context, ArrayList<User> item) {
        inflater = LayoutInflater.from(context);
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        ViewHolder holder=null;
        if (row==null){
            holder = new ViewHolder();
            row = inflater.inflate(R.layout.item_user, null);
            holder.nombre = (TextView) row.findViewById(R.id.tvName);
            holder.edad = (TextView) row.findViewById(R.id.tvEdad);
            holder.altura = (TextView) row.findViewById(R.id.tvEstatura);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        User user = item.get(position);
        holder.nombre.setText(user.getNombre());
        holder.edad.setText(user.getEdad());
        holder.altura.setText(user.getEstatura());
        return row;
    }

    class ViewHolder{
        TextView nombre, edad, altura;
    }
}
