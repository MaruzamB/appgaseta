package com.maruzamjunior.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.maruzamjunior.appgaseta.model.Combustivel;

import java.util.ArrayList;
import java.util.List;

public class GasetaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public GasetaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlTabelaVeiculo = "CREATE TABLE IF NOT EXISTS Veiculo (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeCarro TEXT, " +
                "recomendacao TEXT)";

        sqLiteDatabase.execSQL(sqlTabelaVeiculo);

        String sqlTabelaCombustivel = "CREATE TABLE IF NOT EXISTS Combustivel (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeCombustivel TEXT, " +
                "precoCombustivel REAL, " +
                "recomendacao TEXT)";

        sqLiteDatabase.execSQL(sqlTabelaCombustivel);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados){
       db.insert(tabela, null, dados);
    }
    public List<Combustivel> listarDados(){
        List<Combustivel> lista = new ArrayList<>();

        //Representa um registro que sta na salvo na tabela
        //Combustivel do banco de dados na aplicação

        Combustivel registro;
        String querySQL = "SELECT * FROM Combustivel";
        cursor = db.rawQuery(querySQL, null);

        if (cursor.moveToFirst()){


            do {
               registro = new Combustivel();
               registro.setId(cursor.getInt(0));
               registro.setNomeCombustivel(cursor.getString(1));
               registro.setPrecoCombustivel(cursor.getDouble(2));
               registro.setRecomendacao(cursor.getString(3));
               lista.add(registro);
            }
            while (cursor.moveToNext());

        }
        else{}

        return lista;
    }

    public void alterarObjeto(String tabela, ContentValues dados ){
        int id = dados.getAsInteger("id");
        db.update(tabela, dados, "id=?",
                new String[]{Integer.toString(id)});
    }
    public void deletarObjeto(String tabela, int id ){

        db.delete(tabela,  "id=?",
                new String[]{Integer.toString(id)});
    }

}

