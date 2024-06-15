package lava_jato.app.model;

public class ClientVO {
    private int id;
    private String nome;
    private String senha;
    private String telefone;
    private String cpf;
    private String email;

    public ClientVO(int id, String nome, String senha, String cpf) {
        this.id = id;
        nome = nome;
        senha = senha;
        cpf = cpf;
        String email;
    }

}
