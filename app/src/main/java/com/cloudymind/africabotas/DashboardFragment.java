package com.cloudymind.africabotas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudymind.africabotas.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {


    private FragmentDashboardBinding binding;
    private String usuario;

    public DashboardFragment(String usuario) {
        this.usuario = usuario;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        binding.txtUsuario.setText(String.format("Bienvenido %s", usuario));
        return binding.getRoot();
    }
}