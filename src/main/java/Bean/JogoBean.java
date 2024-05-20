package Bean; 


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.primefaces.event.RowEditEvent;

import java.util.List;
import entidades.Jogo;
import DAO.JogoDao;

@ManagedBean
@RequestScoped
public class JogoBean {

    @PersistenceContext
    private EntityManager em;

    private Jogo jogo;
	private List<Jogo> lista;
	private int maiorNumeroSorteado;


    @PostConstruct
    public void init() {
        jogo = new Jogo();
    }

    public List<Jogo> listar() {
        return em.createQuery("SELECT j FROM Jogo j", Jogo.class).getResultList();
    }

    @Transactional
    public void salvar() {
        try {
            System.out.println(jogo.getV1());
            System.out.println(jogo.getV2());
            System.out.println(jogo.getV3());
            System.out.println(jogo.getV4());
            System.out.println(jogo.getV5());
            
            JogoDao.salvar(jogo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "Jogo salvo com sucesso"));
            jogo = new Jogo();
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Falha ao salvar o jogo"));
   
        }
        
        
    }
    
    public void prepararEdicao(Jogo jogo) {
        this.jogo = jogo;
    }
    
    public void editar() {
		JogoDao.editar(jogo);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Jogo editado com sucesso"));  
	}
	
	public void excluir(Jogo jogo){
		JogoDao.excluir(jogo);
		lista = null;
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Jogo excluido com sucesso"));  
	}
	
	
	
    public List<Jogo> getlistar() {
		if (lista == null) {
			lista = JogoDao.listar();
		}
        return lista;
    }
    public void buscarMaiorNumeroSorteado(){
		maiorNumeroSorteado = JogoDao.buscarMaiorNumeroSorteado();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getLista() {
		return lista;
	}

	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}

	public int getMaiorNumeroSorteado() {
		return maiorNumeroSorteado;
	}

	public void setMaiorNumeroSorteado(int maiorNumeroSorteado) {
		this.maiorNumeroSorteado = maiorNumeroSorteado;
	}
 
    
    
}
