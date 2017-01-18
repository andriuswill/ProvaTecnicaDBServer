import java.awt.print.Printable;
import java.util.Date;

import org.hibernate.Session;

import br.com.provaDBServer.dao.VotoDAO;
import br.com.provaDBServer.domain.Voto;
import br.com.provaDBServer.util.HibernateUtil;

public class testaBanco {
	public static void main(String[] args) {
		
		/*Voto v = new Voto();
		v.setData(new Date());
		v.setFuncionario("Will");
		v.setRestaurante(1);
		
		Voto v2 = new Voto();
		v2.setData(new Date());
		v2.setFuncionario("Andy");
		v2.setRestaurante(2);*/
		
		VotoDAO dao =  new VotoDAO();
		//dao.salvar(v);
		//dao.salvar(v2);
		System.out.println("to aqui");
		System.out.println(dao.resultado(1));
		
	}
}
