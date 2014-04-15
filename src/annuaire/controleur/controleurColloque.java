package annuaire.controleur;
import annuaire.dao.DaoEnsemble;
import annuaire.dao.daoColloque;
import annuaire.metier.Colloque;
import annuaire.view.FrameCreerColloque;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tony
 */
public class controleurColloque {
  
      daoColloque dao;
      
      /**
       * Constructeur de controlleurColloque
       */
      public controleurColloque()
      {
          dao = new daoColloque();
      }
           
      public void colloqueEnregistrement(FrameCreerColloque frameCreate)
      {
          
          String numColloque = frameCreate.getTxtIdColloque().getText();
          long numC =  Long.parseLong(numColloque);
          int nbParticipantMax = Integer.parseInt(frameCreate.getTxtMaxPart().getText());
          int dureeColloque = Integer.parseInt(frameCreate.getTxtDuree().getText());
          String intituleColloque = frameCreate.getTxtIntitule().getText(); 
          String dateDebutColloque = frameCreate.getTxtDate().getText();
          String descriptionColloque = frameCreate.getjTextArea1().getText();
          
          Colloque c = new Colloque(numC,dureeColloque,nbParticipantMax,intituleColloque,dateDebutColloque,descriptionColloque);
          dao.ajouter(c);
                  
      }
      
      /**
       * Procédure qui exporte les données de l'application dans un fichier CSV
       * Informations: Personnes inscrites à un évènement uniquement
       */
      public void exporterDonnee()
      {
          
          // A continuer... 
          
          DaoEnsemble ctrlEnsemble = new DaoEnsemble();
          ResultSet Informations = ctrlEnsemble.getAllInformations();
          
          try
          {
              FileWriter writer = new FileWriter("donnee.csv");
              writer.append("Intitulé,");
              writer.append("Date début");
              writer.append("\n\n");
              while(Informations.next())
              {
                  writer.append(Informations.getString("intitule")+",");
                  writer.append(Informations.getString("date_debut")+"\n");
                  // suite du relevé d'informations
              }
              
              
              writer.flush();
              writer.close();
          }
          catch ( IOException e)
          {
	     e.printStackTrace();
              
         } catch (SQLException ex) {
             System.out.println(ex.toString());
          }
      }
}
