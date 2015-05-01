package pt.c07bd.s10oorelacional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App22CriaInsereFuncionario {
   
   public static void main(String args[]) {
      // nome definido em persistence.xml <persistence-unit>
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      // cria um objeto em memoria e o persiste
      Funcionario f = new Funcionario("Marcelo", "quincas@asdrubolandia.com", "SLKZDHILSZ");
      manager.persist(f);

      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
      
      System.out.println("Tabela criada, dados inseridos!");
   }   
}
