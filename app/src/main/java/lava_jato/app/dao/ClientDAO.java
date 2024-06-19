package lava_jato.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import lava_jato.app.model.ClientVO;
import lava_jato.app.model.HorarioVO;
public class ClientDAO extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "PI-LAVA-JATO";
    private static final int DB_VERSION = 1;
    private static final String TB_HORARIO = "tb_horario";
    private static final String TB_CLIENT = "tb_clients";

    private static final String IDHORARIO = "id_horario";
    private static final String IDCLIENT = "id_client";
    private static final String HORARIOINCIO  = "horario_inicio";
    private static final String HORARIOFINAL = "horario_final";

    private static final String KEY_ID = "id";
    private static final String NOME = "nome";
    private static final String SENHA = "senha";
    private static final String TELEFONE = "telefone";
    private static final String CPF = "cpf";
    private static final String EMAIL = "email";

    public ClientDAO(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TB_CLIENTS = "CREATE TABLE " + TB_CLIENT + " ("
                +KEY_ID + " INTEGER PRIMARY KEY, "
                +NOME + " TEXT, "
                +SENHA + " TEXT, "
                +TELEFONE+ " TEXT, "
                +CPF+ " TEXT, "
                +EMAIL+ " TEXT )";

        String CREATE_TB_HORARIO = "CREATE TABLE " + TB_HORARIO + " ("
                +IDHORARIO + " INTEGER PRIMARY KEY, "
                +HORARIOINCIO + " TEXT, "
                +HORARIOFINAL+ " TEXT, "
                +IDCLIENT+ " INTEGER, "
                +"FOREIGN KEY (IDCLIENT) REFERENCES TB_CLIENT(KEY_ID) )";

        db.execSQL(CREATE_TB_CLIENTS);
        db.execSQL(CREATE_TB_HORARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_CLIENT);
        onCreate(db);
    }

    public void addClient(ClientVO clientVO){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NOME, clientVO.getNome());
        contentValues.put(SENHA, clientVO.getSenha());
        contentValues.put(TELEFONE, clientVO.getTelefone());
        contentValues.put(CPF, clientVO.getCpf());
        contentValues.put(EMAIL, clientVO.getEmail());

        db.insert(TB_CLIENT, null, contentValues);
    }

    public void addHorario(HorarioVO horarioVO){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(IDHORARIO, horarioVO.getIdHorario());
        contentValues.put(IDCLIENT, horarioVO.getIdClient());
        contentValues.put(HORARIOINCIO, horarioVO.getHorarioInicio());
        contentValues.put(HORARIOFINAL, horarioVO.getHorarioTermino());

        db.insert(TB_HORARIO, null, contentValues);
    }
}

