package com.example.almacenamiento6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_Insetar, btn_Editar, btn_Eliminar, btn_ID, btn_Cancelar;
    EditText nombre, apellido, codigo_empleado, cedula, departamento, direccion, sueldo, ID;

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
        ID = findViewById(R.id.txtID);
    }
    public void insertar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("id", ID.getText().toString());
        registro.put("nombre", nombre.getText().toString());
        registro.put("apellido", apellido.getText().toString());
        registro.put("codigo", codigo_empleado.getText().toString());
        registro.put("cedula", cedula.getText().toString());
        registro.put("departamento", departamento.getText().toString());
        registro.put("direccion", direccion.getText().toString());
        registro.put("sueldo", sueldo.getText().toString());
        db.insert("empleado", null, registro);
        db.close();
        ID.setText("");
        nombre.setText("");
        apellido.setText("");
        codigo_empleado.setText("");
        cedula.setText("");
        departamento.setText("");
        direccion.setText("");
        sueldo.setText("");
        Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
    }
    public void editar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("id", ID.getText().toString());
        registro.put("nombre", nombre.getText().toString());
        registro.put("apellido", apellido.getText().toString());
        registro.put("codigo", codigo_empleado.getText().toString());
        registro.put("cedula", cedula.getText().toString());
        registro.put("departamento", departamento.getText().toString());
        registro.put("direccion", direccion.getText().toString());
        registro.put("sueldo", sueldo.getText().toString());
        int i = db.update("empleado", registro, "id="+ ID, null);
        db.close();
        if (i == 1){
            Toast.makeText(this, "Los datos fueron editados", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Los datos no existen", Toast.LENGTH_SHORT).show();
        }
    }
    public void buscarId(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor fila = db.rawQuery("SELECT nombre, apellido, codigo, cedula, departamento, direccion, sueldo FROM empleado WHERE id= "+ID, null);
        if (fila.moveToFirst()) {
            nombre.setText(fila.getString(0));
            apellido.setText(fila.getString(1));
            codigo_empleado.setText(fila.getString(2));
            cedula.setText(fila.getString(3));
            departamento.setText(fila.getString(4));
            direccion.setText(fila.getString(5));
            sueldo.setText(fila.getString(6));
            db.close();
        }
        else{
            Toast.makeText(this, "No existen los datos con dicho ID", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }
    public void eliminar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        int i = db.delete("empleado", "id= "+ID, null);
        db.close();
        ID.setText("");
        nombre.setText("");
        apellido.setText("");
        codigo_empleado.setText("");
        cedula.setText("");
        departamento.setText("");
        direccion.setText("");
        sueldo.setText("");
        if (i == 1) {
            Toast.makeText(this, "Datos eliminados correctamente", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Los datos no fueron eliminados", Toast.LENGTH_SHORT).show();
        }
    }
    public void cancelar(View v){
        ID.setText("");
        nombre.setText("");
        apellido.setText("");
        codigo_empleado.setText("");
        cedula.setText("");
        departamento.setText("");
        direccion.setText("");
        sueldo.setText("");
    }
}