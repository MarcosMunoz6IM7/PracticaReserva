package marcosfernando.edu.mx.ipn.practicareserva;

import android.service.autofill.TextValueSanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActividadReserva extends AppCompatActivity {

    private TextView muestra;

    private String nombre, apellido, telefono, fecha, hora, personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        muestra = (TextView) findViewById(R.id.txtMuestra);

        Bundle recibe = new Bundle();
        recibe = this.getIntent().getExtras();

        nombre = recibe.getString("nombre");
        apellido = recibe.getString("apellido");
        telefono = recibe.getString("telefono");
        hora = recibe.getString("hora");
        fecha = recibe.getString("fecha");
        personas = recibe.getString("personas");


        muestra.setText("Apartado por: " + nombre + " " + apellido + "\n" +
                        "Telefono: " + telefono + "\n" +
                        "Para el dia: " + fecha + "\n" +
                        "Hora: " + hora + "\n" +
                        "Para: " + personas + " personas");
    }
}
