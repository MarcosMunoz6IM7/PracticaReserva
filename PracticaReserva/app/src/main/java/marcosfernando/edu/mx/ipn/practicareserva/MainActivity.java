package marcosfernando.edu.mx.ipn.practicareserva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private TextView tv;
    private SeekBar sb;
    private EditText name,ape,tel,time,date;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creaVariables();

        tv.setText("Cantidad de personas: " + sb.getProgress());
    }

    private void creaVariables(){
        sb = (SeekBar) findViewById(R.id.barInv);
        sb.setOnSeekBarChangeListener(this);
        tv = (TextView) findViewById(R.id.textView);
        name = (EditText) findViewById(R.id.txtName);
        ape = (EditText) findViewById(R.id.txtApe);
        tel = (EditText) findViewById(R.id.txtNum);
        time = (EditText) findViewById(R.id.txtTime);
        date = (EditText) findViewById(R.id.txtDate);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tv.setText("Cantidad de personas: " + sb.getProgress());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        tv.setText("Cantidad de personas: " + sb.getProgress());
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tv.setText("Cantidad de personas: " + sb.getProgress());
    }

    public void reserva(View v){
        Intent I = new Intent(this, ActividadReserva.class);
        Bundle b = new Bundle();

        String p = Integer.toString(sb.getProgress());

        if (p.equals(0)){
            p = "1";
        }

        b.putString("nombre",name.getText().toString());
        b.putString("apellido",ape.getText().toString());
        b.putString("telefono",tel.getText().toString());
        b.putString("hora",time.getText().toString());
        b.putString("fecha",date.getText().toString());
        b.putString("personas",p);

        I.putExtras(b);
        finish();
        startActivity(I);
    }
}
