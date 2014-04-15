package annuaire.controleur;
import annuaire.dao.daoPersonne;
import annuaire.metier.Personne;
import annuaire.view.FrameCreerPersonne;

/**
 * @author Anthony
 */
public class controleurPersonne {
  
      daoPersonne dao;
      /**
       * Constructeur de controleurPersonne
       * 
       */
      public controleurPersonne()
      {
          dao = new daoPersonne();
      }
           
      
      public void personneEnregistrement(FrameCreerPersonne frame)
      {
          long numPers = Long.parseLong(frame.getTxtNumeroPersonne().getText());
          String nomPers = frame.getTxtNomPersonne().getText();
          String prenomPers = frame.getTxtPrenomPersonne().getText();
          String emailPers = frame.getTxtEmailPersonne().getText();
          String dateNaissancePers = frame.getTxtDateNaissancePersonne().getText();
          String organisationPers = frame.getTxtOrganisation().getText();
          String observationPers = frame.getTxtaObservationPersonne().getText();
          Personne p = new Personne(numPers,nomPers,prenomPers,emailPers,dateNaissancePers,organisationPers,observationPers);
          dao.ajouter(p);
                  
      }
      
      //Pour import :
      public void personneAjoutBase(Personne p)
      {
          dao.ajouter(p);
      }
      
      public void personneSuppressionBase (Personne p)
      {
          dao.supprimer((int) p.getNumPers());
      }
      
      public void personneUpdateBase (Personne p)
      {
          dao.update(p);
      }
      /**
       * Cette fonction va recevoir un nom de fichier en paramétre
       * elle va découper afin de ne laisser que l'extension
       * et elle va retourner true si l'extension est bien csv
       * @param fichier
       * @return boolean
       */
      public boolean getExtension(String fichier)
      {
          String extension = "";
          int mid = fichier.lastIndexOf(".");
          extension = fichier.substring(mid+1,fichier.length());
          if (extension.compareTo("csv") == 0)
          {
              return true;
          }else{
              return false;
          }
          
      }
     
}
               
    

