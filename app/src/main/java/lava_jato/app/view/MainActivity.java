package lava_jato.app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import app.lava_jato_pipdm.R;

import lava_jato.app.dao.ClientDAO;
import lava_jato.app.model.ClientVO;
import lava_jato.app.model.HorarioVO;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btnOnClickCadastrarClient(View view) {
        ClientDAO clientDAO = new ClientDAO(this);

        ClientVO clientVO1 = new ClientVO();
        clientVO1.setId(1);
        clientVO1.setNome("Bruno");
        clientVO1.setSenha("21321321");
        clientVO1.setEmail("bb.silva@gmail.com");
        clientVO1.setTelefone("321231");
        clientVO1.setCpf("1321321");

        clientDAO.addClient(clientVO1);

        HorarioVO horarioVO = new HorarioVO();
        horarioVO.setIdClient(1);
        horarioVO.setIdHorario(2);
        horarioVO.setHorarioInicio("18-06-2024-22:00");
        horarioVO.setHorarioTermino("18-06-2024-22:20");

        clientDAO.addHorario(horarioVO);

        Log.d("insert: ", "Registros inseridos no banco de dados...");

    }
}