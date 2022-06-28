package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int KeyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txt_nombre = findViewById(R.id.txt_nombre);
        EditText txt_clave = findViewById(R.id.txt_clave);
        EditText txt_repclave = findViewById(R.id.txt_repclave);
        Button btn_ingresar = findViewById(R.id.btn_ingresar);
        TextView txt_correcto = findViewById(R.id.txt_correcto);
        txt_correcto.setVisibility(View.INVISIBLE);

        txt_clave.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String clave = txt_clave.getText().toString();
                if (clave.length()>4){
                    Context context = MainActivity.this;
                    CharSequence text = "CORRECTO";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    Context context = MainActivity.this;
                    CharSequence text = "5 CARACTERES MINIMO";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }

                return false;
            }
        });

        txt_nombre.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                System.out.println(keyCode);
                KeyCode=keyCode;
                System.out.println(KeyCode);
                if ( KeyCode <= 54 && KeyCode>=29 || KeyCode==67|| KeyCode==62) {

                    return true;
                }else {

                    Context context = MainActivity.this;
                    CharSequence text = "SOLO LETRAS";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return false;
                }




            }

        });

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txt_nombre.getText().toString();
                String clave = txt_clave.getText().toString();
                String repclave = txt_repclave.getText().toString();

                if (clave.equals(repclave)){
                    if (clave.length()>4){


                        txt_correcto.setVisibility(View.VISIBLE);

                        txt_nombre.setText("");
                        txt_clave.setText("");
                        txt_repclave.setText("");


                    }else{
                        Context context = MainActivity.this;
                        CharSequence text = "minimo 5 caracteres";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }


                }else{
                    Context context = MainActivity.this;
                    CharSequence text = "Las claves no coinciden";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }





            }
        });



    }
}