package lucas.sampaio.leite.com.crud_alpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarDadosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_dados);

        String codigo = getIntent().getStringExtra("CODIGO");

        BancoController crud = new BancoController(getBaseContext());

        EditText titulo = (EditText)findViewById(R.id.et_titulo_alterar);
        EditText autor = (EditText)findViewById(R.id.et_autor_alterar);
        EditText editora = (EditText)findViewById(R.id.et_editora_alterar);


        Cursor cursor = crud.carregarDadosbyId(Integer.parseInt(codigo));
        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.TITULO)));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.AUTOR)));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.EDITORA)));

        Button buttonAlterar = (Button) findViewById(R.id.button_alterar_alterar);
        buttonAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alterarDados(Integer.parseInt(codigo),
                        titulo.getText().toString(), autor.getText().toString(),
                        editora.getText().toString());
                Intent intent = new Intent(AlterarDadosActivity.this, ListarDadosActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button buttonDeletar = (Button)findViewById(R.id.button_excluir_alterar);
        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletarDado(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarDadosActivity.this, ListarDadosActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }
}