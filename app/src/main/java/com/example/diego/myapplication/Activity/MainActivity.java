package com.example.diego.myapplication.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.diego.myapplication.Adapter.UserAdapter;
import com.example.diego.myapplication.Model.User;
import com.example.diego.myapplication.R;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    User user;
    UserAdapter adapter;
    ListView listView;
    ArrayList<User> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listViewUser);
        item = new ArrayList<>();
        user = new User();
        user.setNombre("diego");
        user.setEdad("20");
        user.setEstatura("170");
        item.add(user);
        adapter = new UserAdapter(this, item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                user = item.get(position);
                Intent passData = new Intent(getApplication(), MainActivity2Activity.class);
                passData.putExtra("parcel", user);
                startActivity(passData);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            addItem();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addItem() {
        // custom dialog
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.item_dialog);
        dialog.setTitle("Add User");
        final EditText nombre, edad, altura;
        Button cancel, submit;
        nombre= (EditText) dialog.findViewById(R.id.etNombre);
        edad = (EditText) dialog.findViewById(R.id.etEdad);
        altura = (EditText) dialog.findViewById(R.id.etAltura);
        cancel = (Button)dialog.findViewById(R.id.btnCancel);
        submit = (Button)dialog.findViewById(R.id.btnSubmit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setNombre(nombre.getText().toString());
                user.setEdad(edad.getText().toString());
                user.setEstatura(altura.getText().toString());
                item.add(user);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
