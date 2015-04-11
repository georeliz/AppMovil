package software2.appmovil;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import org.json.JSONException;


import software2.appmovil.models.UsuariosModel;


public class Register extends ActionBarActivity {

    UsuariosModel temp = new UsuariosModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void onClick3(View v){
            //acciones boton login

        switch (v.getId()){

            case R.id.button1:
                String resultado;
                resultado = "";
                EditText regUsuario =(EditText)findViewById(R.id.editText1); //nombre de usuario
                EditText regPass = (EditText)findViewById(R.id.editText2);//contraseña
                EditText regConfp = (EditText)findViewById(R.id.editText3);// confirmacion de contraseña

                String usern, pass,cpass;
                usern = regUsuario.getText().toString();
                if(usern.equals("")){
                    Toast.makeText(this,"Ingresa un Usuario",Toast.LENGTH_LONG).show();
                }else{
                    pass =regPass.getText().toString();
                    cpass = regConfp.getText().toString();
                    JSONObject jsonOb = new JSONObject();
                    boolean bandera;
                    bandera=temp.confirmarContraseña(pass,cpass);
                    if(bandera==true){

                        try{
                            jsonOb.put("usuario",usern);
                            jsonOb.put("contrase_a", pass);
                        }catch (JSONException e){}
                        resultado = jsonOb.toString();
                        TextView r = (TextView) findViewById(R.id.resultadoJson);
                        r.setText(resultado,TextView.BufferType.EDITABLE);
                        Toast.makeText(this,"Bienvenido",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this,MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(this,"No coincide la contraseña",Toast.LENGTH_LONG).show();
                    }

                }





        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
