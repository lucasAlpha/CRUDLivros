package lucas.sampaio.leite.com.crud_alpha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriarBD banco;

    public BancoController (Context context){
        banco = new CriarBD(context);
    }

    public String inserirDado(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBD.TITULO, titulo);
        valores.put(CriarBD.AUTOR, autor);
        valores.put(CriarBD.EDITORA, editora);

        resultado = db.insert(CriarBD.TABELA, null, valores);

        if (resultado==-1)
            return "Erro ao inserir registro";
        else
            return "Registro foi inserido com sucesso";

    }

    public Cursor carregarDados(){
        Cursor cursor;
        String[] campos = {banco.ID, banco.TITULO};
        db = banco.getReadableDatabase();

        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarDadosbyId(int id){
        Cursor cursor;
        String[] campos = {banco.ID, banco.TITULO, banco.AUTOR, banco.EDITORA};
        db = banco.getReadableDatabase();
        String where = CriarBD.ID+ " = "+id;

        cursor = db.query(banco.TABELA, campos, where, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alterarDados(int id, String titulo, String autor, String editora){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where= CriarBD.ID+"="+id;

        valores = new ContentValues();
        valores.put(CriarBD.TITULO, titulo);
        valores.put(CriarBD.AUTOR, autor);
        valores.put(CriarBD.EDITORA, editora);

        db.update(CriarBD.TABELA, valores, where, null);
        db.close();
    }

    public void deletarDado(int id){
        String where = CriarBD.ID +"="+id;
        db = banco.getReadableDatabase();
        db.delete(CriarBD.TABELA, where, null);
        db.close();
    }


}
