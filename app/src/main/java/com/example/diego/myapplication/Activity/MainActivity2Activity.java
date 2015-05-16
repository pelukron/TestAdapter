package com.example.diego.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.diego.myapplication.Model.User;
import com.example.diego.myapplication.R;

public class MainActivity2Activity extends ActionBarActivity {

    User user;
    TextView nombre, edad, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        user = getIntent().getParcelableExtra("parcel");
        nombre = (TextView)findViewById(R.id.nombre);
        edad = (TextView)findViewById(R.id.edad);
        altura = (TextView)findViewById(R.id.altura);

        if (user !=null) {
            nombre.setText(user.getNombre());
            edad.setText(user.getEdad());
            altura.setText(user.getEstatura());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
