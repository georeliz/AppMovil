package software2.appmovil.models;

/**
 * Created by Majirowz on 07/04/2015.
 */
public class UsuariosModel {

    public boolean confirmarContraseña(String pass, String cpass){
        boolean bandera= false;
            if(pass.equals("")){
               bandera = false;
            }else{
                if(cpass.equals("")){
                    bandera = false;
                }else{
                    if(pass.equals(cpass)){
                        bandera = true;
                    }else
                    {
                        bandera = false;
                    }
                }
            }
         return bandera;
    }

}
