package com.maruzamjunior.appgaseta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasetaDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "gaseta.db";
    public static final int DB_VERSION = 1;

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



        // Use o sqLiteDatabase passado como parâmetro
       // sqLiteDatabase.execSQL(sqlTabelaVeiculo);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}

