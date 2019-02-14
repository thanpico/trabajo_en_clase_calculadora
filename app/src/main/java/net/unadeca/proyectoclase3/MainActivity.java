package net.unadeca.proyectoclase3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText a = findViewById(R.id.numa);
        final EditText b = findViewById(R.id.numb);
        final TextView resultado = findViewById(R.id.resultado);


        Button sumar =  findViewById(R.id.sumar);
        sumar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(validar(a,b))
                resultado.setText(String.format(Locale.getDefault(),"%d" ,
                        sumar(Integer.parseInt(a.getText().toString()),
                                Integer.parseInt(b.getText().toString()))));


            }
        });

        Button restar =  findViewById(R.id.restar);
        restar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(validar(a,b))
                    resultado.setText(String.format(Locale.getDefault(),"%d" ,
                            restar(Integer.parseInt(a.getText().toString()),
                                    Integer.parseInt(b.getText().toString()))));


            }
        });


    }
    private boolean validar (EditText a, EditText b){

        boolean send = true;

        if(a.getText().toString().isEmpty()){

            a.setText(getResources().getString(R.string.placeholder0));
            send =false;
        }
        if(b.getText().toString().isEmpty()){

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.errorb), Toast.LENGTH_LONG).show();
            send =false;
        }

            return send;
    }

    private int sumar(int a , int b){
        return a + b;
    }
    private int restar(int a , int b){
        return a - b;
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
