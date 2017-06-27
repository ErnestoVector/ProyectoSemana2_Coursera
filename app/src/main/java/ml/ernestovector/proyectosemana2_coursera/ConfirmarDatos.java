package ml.ernestovector.proyectosemana2_coursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

//Se hace que se inicialicen los datos con los valores dados en el formulario
        //Establecemos la referencia al TextView para poder utilizarlo en el codigo
        tvNombre            = (TextView) findViewById(R.id.tvNombre);
        tvFechaNacimiento   = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono          = (TextView) findViewById(R.id.tvTelefono);
        tvEmail             = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion       = (TextView) findViewById(R.id.tvDescripcion);

        //Sacamos el intent que ha iniciado la actividad
        Intent intent = getIntent();

        //Del intent tomamos el bundle en el que hemos introducido los datos de la primer activity
        Bundle b = intent.getExtras();

        //Si el bundle viene vacio, mandamos una inicializacion para evitar errores
        if (b != null){
            //Hacemos la asignacion directamente
            tvNombre.setText(getIntent().getExtras().getString("Nombre"));
            tvFechaNacimiento.setText(getIntent().getExtras().getString("FechaNacimiento"));
            tvTelefono.setText(getIntent().getExtras().getString("Telefono"));
            tvEmail.setText(getIntent().getExtras().getString("Email"));
            tvDescripcion.setText(getIntent().getExtras().getString("Descripcion"));
        }

        //Se declara la funcionalidad del boton... nos lleva de vuelta al MainActivity
        Button back = (Button) findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creamos un bundle para inicializar la otra actividad
                Bundle b = new Bundle();
                b.putString("Nombre", tvNombre.getText().toString());
                b.putString("Telefono", tvTelefono.getText().toString());
                b.putString("Email", tvEmail.getText().toString());
                b.putString("Descripcion", tvDescripcion.getText().toString());

                //Hacemos la conexion entre actividades
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);

                //Añadimos el Bundle para que lleve la informacion al nuevo activity
                intent.putExtras(b);

                //Lanzamos la actividad
                startActivity(intent);
            }
        });



    }
}