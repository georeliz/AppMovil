package software2.appmovil;


import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //conexion con la api enviar datos
    HttpClient httpclient = new DefaultHttpClient(); //
    HttpPost post = new HttpPost("");//url de la api


    public void  onClick(View v){
          switch (v.getId()){

              case R.id.button1:
                String resultado;
                resultado = "";
                EditText logNombre =(EditText)findViewById(R.id.editText1); //getActivity().findViewById(R.id.editText1);
                EditText logPass = (EditText)findViewById(R.id.editText2);//getActivity().findViewById(R.id.editText2);

                String nom, pass;
                nom = logNombre.getText().toString();
                pass =logPass.getText().toString();
                JSONObject jsonOb = new JSONObject();

                if(nom.equals("")){
                    Toast.makeText(this,"Ingresa un Usuario",Toast.LENGTH_LONG).show();
                }else{
                    if(pass.equals("")){
                        Toast.makeText(this,"Ingresa Contraseña",Toast.LENGTH_LONG).show();

                    }else{
                        try{
                            jsonOb.put("nombre",nom);
                            jsonOb.put("contrase_a", pass);

                        }catch (JSONException e){}
                        resultado = jsonOb.toString();
                        TextView r = (TextView) findViewById(R.id.resultadoJson);
                        r.setText(resultado,TextView.BufferType.EDITABLE);
                        Toast.makeText(this,"Bienvenido",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this,MainActivity.class);
                        startActivity(intent);
                    }
                }
                }




    }


    public void onClick2(View v){

        Toast.makeText(this,"Bienvenido",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
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
