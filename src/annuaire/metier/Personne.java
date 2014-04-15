package annuaire.metier;
/**
 * @version final
 * @author anthony 
 */
public class Personne {
    private long numPers;
    private String nomPers, prenomPers, emailPers, dateNaissancePers,organisationPers,observationPers;
    /**
     * Construit un objet Personne
     * @param numPers long
     * @param nomPers String 
     * @param prenomPers String
     * @param emailPers String
     * @param dateNaissancePers String
     * @param organisationPers String
     * @param observationPers String
     */
    public Personne(long numPers, String nomPers, String prenomPers, String emailPers, String dateNaissancePers, String organisationPers, String observationPers) {
        
        this.numPers = numPers;
        this.nomPers = nomPers;
        this.prenomPers = prenomPers;
        this.emailPers = emailPers;
        this.dateNaissancePers = dateNaissancePers;
        this.organisationPers = organisationPers;
        this.observationPers = observationPers;    
    }

    public Personne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getNumPers() {
        return numPers;
    }

    public void setNumPers(long numPers) {
        this.numPers = numPers;
    }

    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    public String getPrenomPers() {
        return prenomPers;
    }

    public void setPrenomPers(String prenomPers) {
        this.prenomPers = prenomPers;
    }

    public String getEmailPers() {
        return emailPers;
    }

    public void setEmailPers(String emailPers) {
        this.emailPers = emailPers;
    }

    public String getDateNaissancePers() {
        return dateNaissancePers;
    }

    public void setDateNaissancePers(String dateNaissancePers) {
        this.dateNaissancePers = dateNaissancePers;
    }

    public String getOrganisationPers() {
        return organisationPers;
    }

    public void setOrganisationPers(String organisationPers) {
        this.organisationPers = organisationPers;
    }

    public String getObservationPers() {
        return observationPers;
    }

    public void setObservationPers(String observationPers) {
        this.observationPers = observationPers;
    }

    @Override
    public String toString() {
        return "Personne{" + "numPers=" + numPers + ", nomPers=" + nomPers + ", prenomPers=" + prenomPers + ", emailPers=" + emailPers + ", dateNaissancePers=" + dateNaissancePers + ", organisationPers=" + organisationPers + ", observationPers=" + observationPers + '}';
    }
    
    
}
