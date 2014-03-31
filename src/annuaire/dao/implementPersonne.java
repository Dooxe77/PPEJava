
package annuaire.dao;

import java.util.List;
import annuaire.metier.Personne;

public interface implementPersonne {

    public void ajouter(Personne b);

    public void update(Personne b);

    public void supprimer(int id);

    public List<Personne> getALL();

    public List<Personne> getRechercheNom(String nom);
}
