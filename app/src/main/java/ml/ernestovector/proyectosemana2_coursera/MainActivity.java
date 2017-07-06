package ml.ernestovector.proyectosemana2_coursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import static android.support.constraint.R.id.parent;

public class MainActivity extends AppCompatActivity {

//Se crean los objetos de tipo EditText para poder utilizarlo en el Layout
    private EditText etNombre;
    private DatePicker dpFechaNacimiento;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establecemos la referencia a los EditText del Layout
        etNombre = (EditText) findViewById(R.id.etNombre);
        dpFechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        //Conectamos la mainActivity con la actividad 2 (ConfirmarDatos)
        Button siguiente = (Button) findViewById(R.id.button_siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Usamos un objeto "bundle" para incluir un par clave-valor.
                //La clave sera "Nombre" y el valor sera el texto introducido en el EditText
                Bundle b = new Bundle();

                b.putString("Nombre", etNombre.getText().toString());
                b.putString("Telefono", etTelefono.getText().toString());
                b.putString("FechaNacimiento", dpFechaNacimiento.getResources().getText(R.string.fecha_muestra).toString());
                b.putString("Email", etEmail.getText().toString());
                b.putString("Descripcion", etDescripcion.getText().toString());

                //Hacemos la conexion entre activities
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);

                //Añadimos el Bundle para que lleve la informacion al nuevo activity
                intent.putExtras(b);

                //Lanzamos la segunda actividad
                startActivity(intent);
            }
        });

        etNombre = (EditText) findViewById(R.id.etNombre);

        //Sacamos el intent que ha iniciado la actividad
        Intent intent = getIntent();

        //Del intent tomamos el bundle en el que hemos introducido los datos de la primer activity
        Bundle b = intent.getExtras();

        //Si el bundle viene vacio, mandamos una inicializacion para evitar errores
        if (b != null){
            //Hacemos la asignacion directamente
            etNombre.setText(getIntent().getExtras().getString("Nombre"));
            etTelefono.setText(getIntent().getExtras().getString("Telefono"));
            etEmail.setText(getIntent().getExtras().getString("Email"));
            etDescripcion.setText(getIntent().getExtras().getString("Descripcion"));
        }

    }


}
