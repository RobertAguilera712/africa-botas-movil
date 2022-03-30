package com.cloudymind.africabotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cloudymind.africabotas.api.Login;
import com.cloudymind.africabotas.api.Servicio;
import com.cloudymind.africabotas.databinding.ActivityMainBinding;
import com.cloudymind.africabotas.model.RespuestaLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Retrofit retrofit = null;
    private Servicio servicio = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        servicio = new Servicio();
        retrofit = servicio.createService();

        binding.txtUsuario.getEditText().setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                binding.txtUsuario.setError(null);
            }
        });

        binding.txtPassword.getEditText().setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                binding.txtPassword.setError(null);
            }
        });


        binding.button.setOnClickListener(v -> {
            login();
        });

    }

    private void login() {
        if (checkInputs()) {
            String usuario = binding.txtUsuario.getEditText().getText().toString();
            String password = binding.txtUsuario.getEditText().getText().toString();

            Login login = retrofit.create(Login.class);
            Call<RespuestaLogin> call = login.login(usuario, password);
            call.enqueue(new Callback<RespuestaLogin>() {
                @Override
                public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {
                    if (response.isSuccessful() && response.code() == 200) {
                        if (response.body() != null) {
                            RespuestaLogin respuesta = response.body();
                            String mensaje;
                            switch (respuesta.getCode()) {
                                case 0:
                                    mensaje = "USUARIO INEXISTENTE";
                                    break;
                                case 1:
                                    mensaje = "ACCESO CONCEDIDO";
                                    break;
                                case 2:
                                    mensaje = "ACCESO DENEGADO";
                                    break;
                                default:
                                    mensaje = "";
                                    break;
                            }
                            Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "BODY IS NULL", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "UNSUCCESSFUL RESPONSE", Toast.LENGTH_SHORT).show();
                    }
                    Log.d("LOGIN", response.toString());
                    Log.d("MESSAGE", response.message());
                    Log.d("LOGIN", String.valueOf(response.code()));
                }

                @Override
                public void onFailure(Call<RespuestaLogin> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Error de conexión", Toast.LENGTH_SHORT).show();
                    Log.e("ERROR", t.getMessage());
                }
            });
        }
    }

    private boolean checkInputs() {
        boolean usuarioFilled = binding.txtUsuario.getEditText().getText().length() > 0;
        boolean passwordFilled = binding.txtPassword.getEditText().getText().length() > 0;

        if (!usuarioFilled) {
            binding.txtUsuario.setError("Debes de llenar el usuario");
        }
        if (!passwordFilled) {
            binding.txtPassword.setError("Debes de llenar el password");
        }
        return usuarioFilled && passwordFilled;
    }

}