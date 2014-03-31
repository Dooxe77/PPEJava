package annuaire.controleur;
import annuaire.dao.DaoEnsemble;

/**
 * @author Anthony
 */
public class controleurEnsemble {
  
      DaoEnsemble daoE;
      
      public controleurEnsemble()
      {
          daoE = new DaoEnsemble();
      }
           
      public void Inscrire(int idP,int idC)
      {
                   
          daoE.ajouter(idP,idC);
      }
      
      public void getNbreParticipant(int idC)
      {
             
      }
      
}
