package lucas.sampaio.leite.com.crud_alpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListarDadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_dados);

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregarDados();

        String[] nomeCampos = new String[]{CriarBD.ID, CriarBD.TITULO};
        int[] idViews = new int[]{R.id.id_livro, R.id.titulo_livro};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.layout_item, cursor, nomeCampos, idViews, 0);
        ListView listView = (ListView) findViewById(R.id.lista_livros);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.ID));
                Intent intent = new Intent(ListarDadosActivity.this, AlterarDadosActivity.class);
                intent.putExtra("CODIGO", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}