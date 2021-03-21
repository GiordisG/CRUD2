package com.example.almacenamiento6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn_Insetar, btn_Editar, btn_Eliminar, btn_ID, btn_Cancelar;
    EditText nombre, apellido, codigo_empleado, cedula, departamento, direccion, sueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Cancelar = findViewById(R.id.buttonCancelar);
        btn_Editar = findViewById(R.id.buttonEditar);
        btn_Eliminar = findViewById(R.id.buttonEliminar);
        btn_Insetar = findViewById(R.id.buttonInsertar);
        btn_ID = findViewById(R.id.buttonID);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        codigo_empleado = findViewById(R.id.txtCodigo_empleado);
        cedula = findViewById(R.id.txtCedula);
        departamento = findViewById(R.id.txtDepartamento);
        direccion = findViewById(R.id.txtDireccion);
        sueldo = findViewById(R.id.txtSueldo);
    }
}