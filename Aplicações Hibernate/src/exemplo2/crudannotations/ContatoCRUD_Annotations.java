/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo2.crudannotations;

import exemplo2.conexao.HibernateUtil;
import java.sql.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ContatoCRUD_Annotations {

    public void salvar (ContatoAnnotations contato){
        Transaction transacao = null;
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(contato);
            transacao.commit();
        }catch (HibernateException e){
            System.out.println("Nao foi possível inserir o contato. Erro" + e.getMessage());
       
        }finally{
            try{
              sessao.close();  
            }catch (Throwable e){
                System.out.println ("Erro ao fechar a operacao de insercao. Mensagem " + e.getMessage());
            }
        }
    }

public void atualizar(ContatoAnnotations contato){
    Session sessao = null;
    Transaction transacao=null;
    
     
     try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(contato);
            transacao.commit();
        }catch (HibernateException e){
            System.out.println("Não foi possivel alterar o contato.Erro: " + e.getMessage());
        }finally{
            try{
                   sessao.close();
                
            }catch (Throwable e){
                System.out.println("Erro ao fechar operacao de atualizacao." + "Mensagem: "+e.getMessage());
            }
        }
    }

public void excluir(ContatoAnnotations contato){
    Session sessao = null;
    Transaction transacao=null;
    
     
     try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(contato);
            transacao.commit();
        }catch (HibernateException e){
            System.out.println("Não foi possivel excluir o contato. Erro: "+ e.getMessage());
        }finally{
            try{
                   sessao.close();
                
            }catch (Throwable e){
                System.out.println("Erro ao fechar operacao de exclusao. Mensagem:"+e.getMessage());
            }
        }
    }

public List<ContatoAnnotations>listar(){
    Session sessao = null;
    Transaction transacao=null;
    Query consulta = null;
    List <ContatoAnnotations> resultado = null;
     try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            consulta=sessao.createSQLQuery("SELECT * FROM CONTATO");
            resultado=consulta.list();
            transacao.commit();
            return resultado;
        }catch (HibernateException e){
            System.out.println("Não foi possivel selecionar contatos. Erro: "+ e.getMessage());
            throw new HibernateException(e);
        }finally{
            try{
                   sessao.close();
            }catch (Throwable e){
                System.out.println("Erro ao fechar operacao de consulta. Mensagem:"+e.getMessage());
            }
        }
    }
public ContatoAnnotations buscaContato(int valor){
        ContatoAnnotations contato = null;
        Session sessao=null;
        Transaction transacao=null;
        Query consulta = null;
        try{
            sessao =  HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Contato where codigo = :parametro");
            consulta.setInteger("parametro",valor);
            transacao.commit();
            return contato;
        }catch (HibernateException e){
            System.out.println("Não foi possível buscar contato. Erro: "+e.getMessage());
            
        }finally{
            try{
                sessao.close();  
            }catch (Throwable e){
                System.out.println("Erro ao fechar operacao de busscar. Mensagem: "+e.getMessage());
            }
        }
        return contato;
    }
public static void main (String[] args){
    ContatoCRUD_Annotations contatoCrudXML = new ContatoCRUD_Annotations();
    String[] nomes = {"Fulano","Beltrano","Ciclano"};
    String[] fones = {"(47) 2222-2222","(47) 9090-2121","(69) 3323-3232"};
    String[] emails = {"Fulano","Beltrano","Ciclano"};
    String[] observacoes = {"Novo Cliente","Cliente em dia","Ligar na quinta"};
    ContatoAnnotations contato = null;

    for (int i = 0; i < nomes.length; i++){
        contato=new ContatoAnnotations();
        contato.setNome(nomes[i]);
        contato.setTelefone(fones[i]);
        contato.setEmail(emails[i]);
        contato.setDataCadastro(new Date (System.currentTimeMillis()));
        contato.setObservacao(observacoes[i]);
        contatoCrudXML.salvar(contato);
    }
    System.out.println("Total de registros cadastrados: " + contatoCrudXML.listar().size());
    }
}

