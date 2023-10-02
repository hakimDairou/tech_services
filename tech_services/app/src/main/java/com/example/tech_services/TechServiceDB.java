package com.example.tech_services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class TechServiceDB extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "nom";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "telephone";
    private static final String COLUMN_COMPETENCE = "competence";
    private static final String COLUMN_CNI = "cni";
    private static final String COLUMN_PASSWORD = "password";


    public TechServiceDB(@Nullable View.OnClickListener context) {
        super((Context) context, "techservices", null, 1);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PHONE + " TEXT, " +
                COLUMN_COMPETENCE + " TEXT, " +
                COLUMN_CNI+ " TEXT, " +

                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }


    // Implémentez une méthode pour insérer un nouvel utilisateur dans la base de données
    public void insertUser(String username, String password, String email, String telephone, String competence, String cni) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Créez un objet ContentValues pour stocker les valeurs à insérer
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, telephone);
        values.put(COLUMN_COMPETENCE, competence);
        values.put(COLUMN_CNI, cni);
        values.put(COLUMN_PASSWORD, password);

        // Insérez les valeurs dans la table
        db.insert(TABLE_USERS, null, values);

        // Fermez la base de données
        db.close();
    }


    // Implémentez une méthode pour vérifier les informations de connexion dans la base de données
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Effectuez une requête pour récupérer l'utilisateur correspondant aux informations de connexion
        String query = "SELECT * FROM " + TABLE_USERS +
                " WHERE " + COLUMN_EMAIL+ " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.rawQuery(query, selectionArgs);

        // Vérifiez si le curseur a renvoyé un enregistrement correspondant
        boolean result = cursor.moveToFirst();

        // Fermez le curseur et la base de données
        cursor.close();
        db.close();

        // Retournez le résultat de la vérification
        return result;
    }



}
