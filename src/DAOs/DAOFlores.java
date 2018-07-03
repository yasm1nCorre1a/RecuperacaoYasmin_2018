package DAOs;


import Entidades.Flores;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOFlores extends DAOGenerico<Flores> {

    public DAOFlores() {
        super(Flores.class);
    }

    public int autoIdFlores() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idFlores) FROM Flores e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Flores> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Flores e WHERE e.nomeFlor LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Flores> listById(int id) {
        return em.createQuery("SELECT e FROM Flores e WHERE e.idFlor = :id").setParameter("id", id).getResultList();
    }

    public List<Flores> listInOrderNome() {
        return em.createQuery("SELECT e FROM Flores e ORDER BY e.nomeFlor").getResultList();
    }

    public List<Flores> listInOrderId() {
        return em.createQuery("SELECT e FROM Flores e ORDER BY e.idFlor").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Flores> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdFlor() + "-" + lf.get(i).getNomeFlor());
        }
        return ls;
    }
public static void main(String[] args) {
        DAOFlores daoFlores = new DAOFlores();
        List<Flores> listaFlores = daoFlores.list();
        for (Flores flores : listaFlores) {
            System.out.println(flores.getIdFlor() + "-" + flores.getNomeFlor());
        }
    }}
