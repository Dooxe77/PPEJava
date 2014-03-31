package annuaire.dao;

import annuaire.connexion.connexion;
import annuaire.metier.Colloque;
import annuaire.view.FrameSupprimerColloque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * @author tony
 */
public class daoColloque implements implementColloque{
    
  
    Connection con;
    final String insert = "INSERT INTO colloque (intitule, date_debut, duree, nb_participant_max, description) VALUES ( ?, ?, ?, ?, ?);";
    final String delete = "delete from colloque where num_col = ?";
    final String maxId = "SELECT maxid from maxid;";
    final String selectAll = "SELECT * from colloque;";
    final String selectOne = "SELECT * from colloque where num_col =";
    final String update = "UPDATE colloque set intitule = ?, date_debut = ?, duree = ? ,nb_participant_max = ?, description = ? where num_col = ? ;";
    
    public daoColloque()
    {
        
        con = connexion.connection();     
    }
    /**
     * Ajoute à la base de donnée une colloque
     * @param uneColloque type colloque en paramètre
     */
    public void ajouter(Colloque b) {
       PreparedStatement statement = null; 
       try
       {
            statement = con.prepareStatement(insert);
            statement.setString(1, b.getIntituleColloque());
            statement.setString(2, b.getDateDebutColloque());
            statement.setInt(3, b.getDureeColloque());
            statement.setInt(4, b.getNbParticipantMax());
            statement.setString(5, b.getDescriptionColloque());
            
            statement.executeUpdate();
       }
       catch (SQLException ex) 
       {
           System.out.println(ex.toString());
       }
       finally {
            try
            {
                statement.close();
                
            } catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
       }
    }
    
    /**
     * Procédure: Met à jour une colloque dans la base de donnée. 
     * @param numColloque numéro de colloque (primary key)
     */
    public void update(Colloque c) {
       
       PreparedStatement statement = null; 
       try
       {
            statement = con.prepareStatement(update);        
            statement.setString(1, c.getIntituleColloque());
            statement.setString(2, c.getDateDebutColloque());
            statement.setInt(3, c.getDureeColloque());
            statement.setInt(4, c.getNbParticipantMax());
            statement.setString(5, c.getDescriptionColloque());
            statement.setLong(6, c.getNumColloque());
            
            statement.executeUpdate();
       }
       catch (SQLException ex) 
       {
           System.out.println(ex.toString());
       }
       finally {
            try
            {
                statement.close();
                
            } catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
       }
    }
   
    /**
     * Supprime une colloque par l'id passé en parametre
     * @param id id de la colloque
     */
    public void supprimer(int id, FrameSupprimerColloque fr) {
       PreparedStatement statement = null; 
       try
       {
            statement = con.prepareStatement(delete);        
            statement.setInt(1, id);
            statement.executeUpdate();
       }
       catch (SQLException ex) 
       {
           JOptionPane.showMessageDialog(fr, "Vous ne pouvez pas supprimer cet évènement, des participants semblent y participer...");
       }
       finally {
            try
            {
                statement.close();
                
            } catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
       }
    }
    
    /**
     * Retourne un tableau de colloque chargé grâce aux informations 
     * de la base de donnée
     * @return ArrayList tableau de colloque
     */
    public List<Colloque> getALL() {
        
        ArrayList<Colloque> listeColloque = new ArrayList();  
        Statement stm ;
        ResultSet resultats;
        // déclaration des variables pour la création de la colloque
        long numC;
        int nbParticipantMax;
        int dureeColloque;
        String intituleColloque; 
        String dateDebutColloque;
        String descriptionColloque;
          
        try{
            stm =  con.createStatement();
            resultats = stm.executeQuery(selectAll);
            Colloque c;
            
            while(resultats.next())
            {
                numC = resultats.getLong("num_col");
                nbParticipantMax = resultats.getInt("nb_participant_max");
                dureeColloque = resultats.getInt("duree");
                intituleColloque = resultats.getString("intitule");
                dateDebutColloque = resultats.getString("date_debut");
                descriptionColloque = resultats.getString("description");
                c  = new Colloque(numC,dureeColloque, nbParticipantMax, intituleColloque, dateDebutColloque,descriptionColloque);
                listeColloque.add(c);
            }   
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        
        return listeColloque;    
    }
    
    /**
     * Retourne une colloque avec pour argument le numéro de colloque désiré
     * @param numColloque
     * @return Colloque
     */
    public  Colloque getUneColloque(int numColloque) {
        
        Statement stm ;
        ResultSet resultats;
        Colloque c = null;
        // déclaration des variables pour la création de la colloque
        long numC;
        int nbParticipantMax;
        int dureeColloque;
        String intituleColloque; 
        String dateDebutColloque;
        String descriptionColloque;
          
        try{
            stm =  con.createStatement();
            resultats = stm.executeQuery(selectOne + numColloque);
            resultats.next();
            
            numC = resultats.getLong("num_col");
             nbParticipantMax = resultats.getInt("nb_participant_max");
                dureeColloque = resultats.getInt("duree");
                intituleColloque = resultats.getString("intitule");
                dateDebutColloque = resultats.getString("date_debut");
                descriptionColloque = resultats.getString("description");
                c  = new Colloque(numC,dureeColloque, nbParticipantMax, intituleColloque, dateDebutColloque,descriptionColloque);
             
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        
        return c;    
        
    }
    
    /**
     * retourne l'id max de la base de donnée des colloques
     * @return int l'id maximum
     */
    public int getMaxId()
    {
        Statement stm ;
        ResultSet resultats;
        int maxid = -1;
        try{
            stm =  con.createStatement();
            resultats = stm.executeQuery(maxId);
            resultats.next();
            maxid = resultats.getInt("maxid");
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
       
        return maxid;
    }

}
