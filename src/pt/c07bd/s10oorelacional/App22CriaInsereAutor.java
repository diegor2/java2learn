package pt.c07bd.s10oorelacional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App22CriaInsereAutor {
   
   public static void main(String args[]) {
      // nome definido em persistence.xml <persistence-unit>
      EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("biblioteca-oo");
      EntityManager manager = factory.createEntityManager();   
      
      manager.getTransaction().begin();
      
      // cria um objeto em memoria e o persiste
      
      Autor m = new Autor("Moises", "quincas@asdrubolandia.com", "Policial");
      manager.persist(m);
      Autor d = new Autor("Diego", "quincas@asdrubolandia.com", "Policial");
      manager.persist(d);
      
      Autor a = new Autor("Quincas", "quincas@asdrubolandia.com", "Policial");
      a.getCoAutor().add(m);
      a.getCoAutor().add(d);
      manager.persist(a);

      manager.getTransaction().commit();
      
      manager.close();
      factory.close();
      
      System.out.println("Tabela criada, dados inseridos!");
   }   
}
