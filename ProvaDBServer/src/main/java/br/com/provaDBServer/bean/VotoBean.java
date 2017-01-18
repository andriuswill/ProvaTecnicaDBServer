package br.com.provaDBServer.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.exception.ConstraintViolationException;
import org.omnifaces.util.Messages;

import br.com.provaDBServer.dao.VotoDAO;
import br.com.provaDBServer.domain.Voto;

@ManagedBean
@ViewScoped
public class VotoBean implements Serializable {
	
	private Voto voto;
	
	public Voto getVoto() {
		return voto;
	}
	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	
	
	@PostConstruct
	public void novo() {
        voto = new Voto();
    }
	
	public Long getVotos(int restaurante){
		VotoDAO votoDAO = new VotoDAO();
		return votoDAO.resultado(restaurante);
	}

	public Boolean encerrada(int dia){
		Date data = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(data);
        if (dia < gc.get(GregorianCalendar.DAY_OF_WEEK))
        	return true;
        else if (dia == gc.get(GregorianCalendar.DAY_OF_WEEK) && passouMeioDia())
        	return true;
        return false;
	}
	
	public Boolean passouMeioDia(){						
			Date atual = new Date();
			if(atual.getHours() >= 12){
				System.out.println("Passou");
				return true;
			}
			else{
				System.out.println("Nao passou");
				return false;
			}		
	}
	
	public Boolean aberta (int dia) throws ParseException{		 
        Date data = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(data);
        return ((gc.get(GregorianCalendar.DAY_OF_WEEK) == dia) && (!passouMeioDia()));
	}	
	
	public Boolean hoje(int dia) {
		Date data = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        return gc.get(GregorianCalendar.DAY_OF_WEEK) == dia;
	}

    public void salvar() {
        try {
            VotoDAO votoDAO = new VotoDAO();
            votoDAO.salvar(voto);
            voto = new Voto();            
            Messages.addGlobalInfo("Voto feito !!!");
        } catch (ConstraintViolationException erro) {
            Messages.addGlobalError("Apenas um voto por usuário...");
            erro.printStackTrace();            
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao votar...");
            erro.printStackTrace();
        }
    }
    
    
	
}
