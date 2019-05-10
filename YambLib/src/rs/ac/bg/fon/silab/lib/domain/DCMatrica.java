/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.lib.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.silab.lib.domain.constants.Constants;

/**
 *
 * @author MARINA
 */
public class DCMatrica implements GeneralDObject, CompundDObject, ChildDObject, Serializable {
    
       static List<DCMatrica> matrice = new ArrayList<>();

    private DCIgra igra;
    private Long matricaId;
    private Long krajnjiRezultat;
    private boolean pobeda;
    private DCKorisnik korisnik;
    private List<DCPolje> polja;

        private String customWhereCondition;


       @Override
    public String getCustomWhereCondition() {
        return customWhereCondition;
    }

    public void setCustomWhereCondition(String customWhereCondition) {
        this.customWhereCondition = customWhereCondition;
    }
        
    public static DCMatrica getInstance() {
        DCMatrica newMatrica = new DCMatrica(DCIgra.getInstance(),0L);
        if (matrice.contains(newMatrica)) {
            return matrice.get(matrice.indexOf(newMatrica));
        } else {
            matrice.add(newMatrica);
            return newMatrica;
        }

    }
    
    public static DCMatrica getInstance(DCIgra igra){
        DCMatrica newMatrica = new DCMatrica(igra);
        if (matrice.contains(newMatrica)) {
            return matrice.get(matrice.indexOf(newMatrica));
        } else {
            matrice.add(newMatrica);
            return newMatrica;
        }
    }

    public static DCMatrica getInstance(Long igraId,Long matricaId) {
        DCMatrica newMatrica = new DCMatrica(DCIgra.getInstance(igraId),matricaId);
        if (matrice.contains(newMatrica)) {
            return matrice.get(matrice.indexOf(newMatrica));
        } else {
            matrice.add(newMatrica);
            return newMatrica;
        }
    }

    public static DCMatrica getInstance(DCIgra igra, Long matricaId, Long krajnjiRezultat, boolean pobeda, DCKorisnik korisnik) {
        DCMatrica newMatrica = new DCMatrica(igra, matricaId, krajnjiRezultat, pobeda, korisnik);
        if (matrice.contains(newMatrica)) {
            DCMatrica existingMatrica = matrice.get(matrice.indexOf(newMatrica));
            existingMatrica.update(newMatrica);
            return existingMatrica;
        } else {
            matrice.add(newMatrica);
            return newMatrica;
        }
    }
    
    private DCMatrica(DCIgra igra, Long matricaId) {
        this.igra = igra;
        this.matricaId = matricaId;
        polja = new ArrayList<>();
    }

    private DCMatrica(DCIgra igra) {
        this.igra = igra;
        polja = new ArrayList<>();
    }
    
    

    private DCMatrica(DCIgra igra, Long matricaId, Long krajnjiRezultat, boolean pobeda, DCKorisnik korisnik) {
        this.igra = igra;
        this.matricaId = matricaId;
        this.krajnjiRezultat = krajnjiRezultat;
        this.pobeda = pobeda;
        this.korisnik = korisnik;
        polja = new ArrayList<>();
    }

    private DCMatrica() {
        polja = new ArrayList<>();
    }

    @Override
    public String getAtrValue() {
        return igra.getIgraId() + "," + matricaId + "," + krajnjiRezultat + "," + pobeda + "," + korisnik.getKorisnikId();
    }

    @Override
    public String setAtrValue() {
        return Constants.Matrica.IGRA_ID_FK + "=" + igra.getIgraId() + ","
                + Constants.Matrica.MATRICA_ID + "=" + matricaId + ","
                + Constants.Matrica.KRAJNJI_REZULTAT + "=" + krajnjiRezultat + ","
                + Constants.Matrica.POBEDA + "=" + pobeda + ","
                + Constants.Matrica.KORISNIK_ID_FK + "=" + korisnik.getKorisnikId();
    }

    @Override
    public String getClassName() {
        return Constants.Matrica.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return Constants.Matrica.IGRA_ID_FK + ","
                + Constants.Matrica.MATRICA_ID + ","
                + Constants.Matrica.KRAJNJI_REZULTAT + ","
                + Constants.Matrica.POBEDA + ","
                + Constants.Matrica.KORISNIK_ID_FK;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Matrica.IGRA_ID_FK + "=" + igra.getIgraId() + " AND " + Constants.Matrica.MATRICA_ID + "=" + matricaId;
    }

    @Override
    public String getNameByColumn(int column) {
        return new String[]{Constants.Matrica.IGRA_ID_FK, Constants.Matrica.MATRICA_ID, Constants.Matrica.KRAJNJI_REZULTAT, Constants.Matrica.POBEDA, Constants.Matrica.KORISNIK_ID_FK}[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        System.out.println("Checking constratints for Matrica");
    }

    @Override
    public void setKey(ResultSet rs) throws Exception {

    }

    @Override
    public String[] getColumns() {
        return new String[]{Constants.Matrica.IGRA_ID_FK, Constants.Matrica.MATRICA_ID, Constants.Matrica.KRAJNJI_REZULTAT, Constants.Matrica.POBEDA, Constants.Matrica.KORISNIK_ID_FK};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Matrica.IGRA_ID_FK:
                return igra;
            case Constants.Matrica.MATRICA_ID:
                return matricaId;
            case Constants.Matrica.KRAJNJI_REZULTAT:
                return krajnjiRezultat;
            case Constants.Matrica.POBEDA:
                return pobeda;
            case Constants.Matrica.KORISNIK_ID_FK:
                return korisnik;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Matrica.IGRA_ID_FK, Constants.Matrica.MATRICA_ID};
    }

    @Override
    public List<String> classNames() {
        List<String> classNames = new ArrayList<>();
        classNames.add(Constants.Polje.CLASS_NAME);
        return classNames;
    }

    @Override
    public List<GeneralDObject> getItemsFor(String className) {
        switch (className) {
            case Constants.Polje.CLASS_NAME:
                return new ArrayList<>(polja);
            default:
                return null;
        }
    }

    @Override
    public GeneralDObject createChild(String className) {
        switch (className) {
            case Constants.Polje.CLASS_NAME:
                return DCPolje.getInstance(this);
            default:
                return null;
        }
    }

    @Override
    public String getWhere(String className) {
        return Constants.Matrica.IGRA_ID_FK + "=" + igra.getIgraId() + " AND " + Constants.Matrica.MATRICA_ID + "=" + matricaId; 
    }

    @Override
    public String getParentWhere() {
        return Constants.Matrica.IGRA_ID_FK + "=" + igra.getIgraId();
    }

    public DCIgra getIgra() {
        return igra;
    }

    public void setIgra(DCIgra igra) {
        this.igra = igra;
    }

    public Long getMatricaId() {
        return matricaId;
    }

    public void setMatricaId(Long matricaId) {
        this.matricaId = matricaId;
    }

    public Long getKrajnjiRezultat() {
        return krajnjiRezultat;
    }

    public void setKrajnjiRezultat(Long krajnjiRezultat) {
        this.krajnjiRezultat = krajnjiRezultat;
    }

    public boolean isPobeda() {
        return pobeda;
    }

    public void setPobeda(boolean pobeda) {
        this.pobeda = pobeda;
    }

    public DCKorisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(DCKorisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<DCPolje> getPolja() {
        return polja;
    }

    public void setPolja(List<DCPolje> polja) {
        this.polja = polja;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DCMatrica other = (DCMatrica) obj;
        if (!Objects.equals(this.igra, other.igra)) {
            return false;
        }
        if (!Objects.equals(this.matricaId, other.matricaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "matrica";
    }

    @Override
    public void setValue(String column, ResultSet rs, GeneralDObject gdo) {
        try {
            switch(column){
                case Constants.Matrica.IGRA_ID_FK:
                    igra = DCIgra.getInstance(rs.getLong(column));
                    break;
                case Constants.Matrica.MATRICA_ID:
                    matricaId = rs.getLong(column);
                    break;
                case Constants.Matrica.KRAJNJI_REZULTAT:
                    krajnjiRezultat = rs.getLong(column);
                    break;
                case Constants.Matrica.POBEDA:
                    pobeda = rs.getBoolean(column);
                    break;
                case Constants.Matrica.KORISNIK_ID_FK:
                    korisnik = DCKorisnik.getInstance(rs.getLong(column));
                    if(gdo != null)korisnik.update(gdo);
                    break;
                    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GeneralDObject gdo) {
        krajnjiRezultat = ((DCMatrica)gdo).getKrajnjiRezultat();
        pobeda = ((DCMatrica)gdo).isPobeda();
        korisnik = ((DCMatrica)gdo).getKorisnik();
    }

    @Override
    public void addChild(GeneralDObject gdo) {
        switch(gdo.getClassName()){
            case Constants.Polje.CLASS_NAME:
                if(!polja.contains(gdo)){
                    polja.add((DCPolje) gdo);
                }
                break;
        }
    }
    

    public DCPolje getPolje(int kolona, int red){
        for (DCPolje dCPolje : polja) {
            if(dCPolje.getKolona().getKolonaId() == kolona && dCPolje.getRed().getRedId() == red)return dCPolje;
        }
        return null;
    }

    @Override
    public GeneralDObject getInstance(ResultSet rs) {
           try {
               return getInstance(rs.getLong(Constants.Matrica.IGRA_ID_FK), rs.getLong(Constants.Matrica.MATRICA_ID));
           } catch (SQLException ex) {
               ex.printStackTrace();
               return null;
           }
    }
}
