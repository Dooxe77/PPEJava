
package annuaire.dao;
import annuaire.connexion.connexion;
import annuaire.metier.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anthony 
 */

public class daoPersonne implements implementPersonne {

    Connection connection;
    final String insert = "INSERT INTO personne (nom_pers,prenom_pers,email_pers,date_naiss,organisation,observations) VALUES ( ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE personne set nom_pers=?, prenom_pers=?, email_pers=?,date_naiss=?,organisation=?,observations=? where num_pers=? ;";
    final String delete = "DELETE FROM personne where num_pers=? ;";
    final String select = "SELECT * FROM personne;";
    final String recherchenom = "SELECT * FROM personne where nom like ?";
    final String maxId = "SELECT maxidP from maxidp;";
    public daoPersonne() {
        connection = connexion.connection();
    }

    public void ajouter(Personne p) {
        PreparedStatement statement = null; 
       
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, p.getNomPers() );
            statement.setString(2, p.getPrenomPers());
            statement.setString(3, p.getEmailPers());
            statement.setString(4, p.getDateNaissancePers());
            statement.setString(5, p.getOrganisationPers());
            statement.setString(6, p.getObservationPers());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
           /** while (rs.next()) {
               b.setId(rs.getInt(1));
               
            }*/
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
 
    public void update(Personne b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNomPers());
            statement.setString(2, b.getPrenomPers());
            statement.setString(3, b.getEmailPers());
            statement.setString(4, b.getDateNaissancePers());
            statement.setString(5, b.getOrganisationPers());
            statement.setString(6, b.getObservationPers());
            statement.setLong(7, (int) b.getNumPers());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void supprimer(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Personne> getALL() {
        ArrayList<Personne> lb = null;
        try {
            lb = new ArrayList<Personne>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                long id;
                String nom,prenom,mail,date,org,obs;
                id = rs.getLong(1);
                nom = rs.getString(2);
                prenom = rs.getString(3);
                mail = rs.getString(4);
                date = rs.getString(5);
                org = rs.getString(6);
                obs = rs.getString(7);
                Personne p = new Personne(id,nom,prenom,mail,date,org,obs);
                lb.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }
/**
    public List<Personne> getRechercheNom(String nom) {
        List<Personne> lb = null;
        try {
            lb = new ArrayList<Personne>();
            PreparedStatement st = connection.prepareStatement(recherchenom);
            st.setString(1, "%" + nom + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Personne b = new Personne();
                b.setId(rs.getInt("id"));
                b.setNum(rs.getString("num"));
                b.setNom(rs.getString("nom"));
                b.setAdresse(rs.getString("adresse"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
   */ 
     public int getMaxIdP()
    {
        Statement stm ;
        ResultSet resultats;
        int maxid = -1;
        try{
            stm =  connection.createStatement();
            resultats = stm.executeQuery(maxId);
            resultats.next();
            maxid = resultats.getInt("maxidP");
            
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
       
        return maxid;
    }

    public List<Personne> getRechercheNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
}
