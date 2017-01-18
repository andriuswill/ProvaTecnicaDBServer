package br.com.provaDBServer.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.provaDBServer.domain.Voto;
import br.com.provaDBServer.util.HibernateUtil;

public class VotoDAO {
		
	public void salvar(Voto voto) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		voto.setData(new Date());
		try {
			transacao = sessao.beginTransaction();
			sessao.save(voto);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public List<Voto> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Voto.class);			
			List<Voto> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public Long resultado (int restaurante){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Voto.class);	
			consulta.add(Restrictions.eq("restaurante", restaurante));
			consulta.add(Restrictions.eq("data", new Date()));
			return (Long) consulta.setProjection(Projections.rowCount()).uniqueResult();
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
