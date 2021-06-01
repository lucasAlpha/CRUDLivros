package lucas.sampaio.leite.com.crud_alpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CadastrarActivity.class);
                startActivity(it);
            }
        });

        Button buttonListar = (Button) findViewById(R.id.buttonList);
        buttonListar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ListarDadosActivity.class);
                startActivity(it);
            }
        });

        Button buttonAlterar = (Button) findViewById(R.id.buttonUpd);
        buttonAlterar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ListarDadosActivity.class);
                startActivity(it);
            }
        });

    }
}