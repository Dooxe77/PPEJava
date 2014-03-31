package annuaire.dao;
import annuaire.metier.Colloque;
import annuaire.view.FrameSupprimerColloque;
import java.util.List;
/**
 *
 * @author tony
 */
public interface implementColloque {
    

    public void ajouter(Colloque b);

    public void update(Colloque uneColloque);

    public void supprimer(int id, FrameSupprimerColloque fr);

    public  List<Colloque> getALL();

    public Colloque getUneColloque(int numColloque);


}
