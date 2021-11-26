import exemplo2.conexao.HibernateUtil;
import org.hibernate.Session;

public class ConectaHibernateMySQL {
    public static void main (String[] args){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Conectou!");
        }finally{
            sessao.close();
        }
    }
    
}
