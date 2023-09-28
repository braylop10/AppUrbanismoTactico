package co.edu.unipiloto.app_urbanismo_tactico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class InicioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuprincipal,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==R.id.item1){
            Toast.makeText(this,"oprimiste el boton reportar situacion",Toast.LENGTH_SHORT).show();
        } else if (id==R.id.item2) {
            Toast.makeText(this,"oprimiste el boton ver estadisticas",Toast.LENGTH_SHORT).show();
        }else if (id==R.id.item3) {
            Toast.makeText(this,"oprimiste el boton historial de reportes",Toast.LENGTH_SHORT).show();
        }else if (id==R.id.item4) {
            Toast.makeText(this,"oprimiste el boton salir",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(InicioActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}