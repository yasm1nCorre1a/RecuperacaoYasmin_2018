package DAOs;


import Entidades.Tipo;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOTipo extends DAOGenerico<Tipo> {

    public DAOTipo() {
        super(Tipo.class);
    }

    public int autoIdTipo() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idTipo) FROM Tipo e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Tipo> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Tipo e WHERE e.nomeTipo LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Tipo> listById(int id) {
        return em.createQuery("SELECT e FROM Tipo e WHERE e.idTipo = :id").setParameter("id", id).getResultList();
    }

    public List<Tipo> listInOrderNome() {
        return em.createQuery("SELECT e FROM Tipo e ORDER BY e.nomeTipo").getResultList();
    }

    public List<Tipo> listInOrderId() {
        return em.createQuery("SELECT e FROM Tipo e ORDER BY e.idTipo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Tipo> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdTipo() + "-" + lf.get(i).getNomeTipo());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOTipo daoTipo = new DAOTipo();
        List<Tipo> listaTipo = daoTipo.list();
        for (Tipo tipo : listaTipo) {
            System.out.println(tipo.getIdTipo() + "-" + tipo.getNomeTipo());
        }
    }}
