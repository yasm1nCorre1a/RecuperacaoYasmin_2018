package DAOs;


import Entidades.Sexo;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOSexo extends DAOGenerico<Sexo> {

    public DAOSexo() {
        super(Sexo.class);
    }

    public int autoIdSexo() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idSexo) FROM Sexo e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Sexo> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Sexo e WHERE e.nomeSexo LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Sexo> listById(int id) {
        return em.createQuery("SELECT e FROM Sexo e WHERE e.idSexo = :id").setParameter("id", id).getResultList();
    }

    public List<Sexo> listInOrderNome() {
        return em.createQuery("SELECT e FROM Sexo e ORDER BY e.nomeSexo").getResultList();
    }

    public List<Sexo> listInOrderId() {
        return em.createQuery("SELECT e FROM Sexo e ORDER BY e.idSexo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Sexo> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdSexo() + "-" + lf.get(i).getNomeSexo());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOSexo daoSexo = new DAOSexo();
        List<Sexo> listaSexo = daoSexo.list();
        for (Sexo sexo : listaSexo) {
            System.out.println(sexo.getIdSexo() + "-" + sexo.getNomeSexo());
        }
    }}
