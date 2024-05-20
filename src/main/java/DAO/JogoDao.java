package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.Jogo;
import UTIL.JPAutil;
	
public class JogoDao {
	
	public static void salvar(Jogo jogo) {
        EntityManager em = JPAutil.criarEntityManager();
        try {
            em.getTransaction().begin(); //inicia a transação
            em.merge(jogo); //prepara o salvamento
            em.getTransaction().commit(); //envia o salvamento
            em.close(); //fecha a transação
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
	
	public static void editar (Jogo jogo) {
		EntityManager em = JPAutil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(jogo);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir (Jogo jogo) {
		EntityManager em = JPAutil.criarEntityManager();
		em.getTransaction().begin();
		jogo = em.find(Jogo.class, jogo.getId());
		if (jogo!= null) {
		em.remove(jogo);	
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Jogo> listar () {
		EntityManager em = JPAutil.criarEntityManager();
		Query q = em.createQuery("SELECT j FROM Jogo j");
		List<Jogo> resultado = q.getResultList();
		em.close();
		return resultado;
	}
	
	public static Integer buscarMaiorNumeroSorteado() {
		EntityManager em = JPAutil.criarEntityManager();
		Query q = em.createNamedQuery("Jogo.buscarMaiorNumeroSorteado");
		Object result = q.getSingleResult();
		// Verifica se o resultado é nulo e converte para inteiro
		Integer maiorNumero = (result!= null) ? ((Number) result).intValue() : null;
		em.clear();
		return maiorNumero;
	}
}
