package lucas.sampaio.leite.com.crud_alpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        Button button = (Button)findViewById(R.id.button_cadastrar_cadastrar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());

                EditText titulo = (EditText)findViewById(R.id.et_titulo);
                EditText autor = (EditText)findViewById(R.id.et_autor);
                EditText editora = (EditText)findViewById(R.id.et_editora);

                String tituloString = titulo.getText().toString();
                String autorString = autor.getText().toString();
                String editoraString = editora.getText().toString();

                String resultado = crud.inserirDado(tituloString, autorString, editoraString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                Intent it = new Intent(CadastrarActivity.this, ListarDadosActivity.class);
                startActivity(it);
                finish();

            }
        });

    }
}