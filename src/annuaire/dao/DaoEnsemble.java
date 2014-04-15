package annuaire.dao;

import annuaire.connexion.connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tony
 * @author anthony 
 */
public class DaoEnsemble {
   
   Connection con;
   private final String reqVisualiser = "select colloque.*,personne.* from inscrire, colloque, personne where inscrire.num_pers = personne.num_pers and colloque.num_col = inscrire.num_col;";
   private final String Inscrire = "INSERT into inscrire(num_pers,num_col,date_ins) VALUES ( ?, ?, ?);";
   private final String getUtilisateurParcipant ="select p.num_pers,nom_pers from inscrire i, personne p where i.num_pers = p.num_pers and i.num_col = ?;";
   private final String getNbreParticipant = "SELECT COUNT(*) from inscrire where num_col = ? ;";
   private Date date = new Date();
   private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
   private String dateString = dateFormat.format(date);
   
   public DaoEnsemble()
   {
       con = connexion.connection();
   }
   
   /**
    * Récupère toutes les informations d'un évènement
    * @return ResultSet le résultat de la requête non trié
    */
   public ResultSet getAllInformations()
   {
          Statement stm;
          ResultSet resultats = null;
   
          try
          {
              stm =  con.createStatement();
              resultats = stm.executeQuery(reqVisualiser);      
          }
          catch(SQLException e)
          {
              e.toString();
          }
          
        return resultats;
   }
   
   /**
    * Ajoute une colloque en fonction de l'id de la personne et de la colloques
    * C'est une procédure
    */
   public void ajouter(int idP,int idC) {
        PreparedStatement statement = null; 
       
        try {
            statement = con.prepareStatement(Inscrire);
            statement.setInt(1,idP);
            statement.setInt(2,idC);
            statement.setString(3, dateString);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
          
        } catch (SQLException ex) {
            //System.out.println(ex.toString());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            }
        }
    }
   
   /**
    * Récupère les personnes participant à une colloque dont l'identifiant 
    * est passé en paramètre dans une ArrayList
    * @param id Integer: numéro de colloque
    * @return ArrayList<String> nom des personnes inscrites à la colloque
    */
   public ArrayList<String> getPersonneByColloque(int id)
   {
       ArrayList<String> listeNom = new ArrayList();
       PreparedStatement statement = null; 
       
        try {
            statement = con.prepareStatement(getUtilisateurParcipant);
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                listeNom.add(rs.getString("nom_pers"));
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            }
        }
        
        return listeNom;
   }
}
