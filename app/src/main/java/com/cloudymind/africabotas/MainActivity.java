package com.cloudymind.africabotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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

        binding.button.setOnClickListener(v -> {

        });
    }

    private void login(){
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
                        switch (respuesta.getCode()){
                            case 1:
                                break;
                        }
                    } else {
                    }
                } else {
                }
                Log.d("LOGIN", response.toString());
                Log.d("MESSAGE", response.message());
                Log.d("LOGIN", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<RespuestaLogin> call, Throwable t) {

            }
        });
    }
}