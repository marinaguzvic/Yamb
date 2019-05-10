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
import rs.ac.bg.fon.silab.lib.domain.constants.Constants;

/**
 *
 * @author MARINA
 */
public class DCPolje implements GeneralDObject, ChildDObject, Serializable {
        static List<DCPolje> polja = new ArrayList<>();
        
    private DCMatrica matrica;
    private Long poljeId;
    private Long vrednost;
    private DCKolona kolona;
    private DCRed red;

        private String customWhereCondition;

        @Override
    public String getCustomWhereCondition() {
        return customWhereCondition;
    }

    public void setCustomWhereCondition(String customWhereCondition) {
        this.customWhereCondition = customWhereCondition;
    }
        
    public static DCPolje getInstance() {
        DCPolje newPolje = new DCPolje(DCMatrica.getInstance(),0L);
        if (polja.contains(newPolje)) {
            return polja.get(polja.indexOf(newPolje));
        } else {
            polja.add(newPolje);
            return newPolje;
        }

    }
    
    public static DCPolje getInstance(DCMatrica matrica){
        DCPolje newPolje = new DCPolje(matrica);
        if (polja.contains(newPolje)) {
            return polja.get(polja.indexOf(newPolje));
        } else {
            polja.add(newPolje);
            return newPolje;
        }
    }

    public static DCPolje getInstance(Long igraId,Long matricaId, Long poljeId) {
        DCPolje newPolje = new DCPolje(DCMatrica.getInstance(igraId,matricaId),poljeId);
        if (polja.contains(newPolje)) {
            return polja.get(polja.indexOf(newPolje));
        } else {
            polja.add(newPolje);
            return newPolje;
        }
    }

    public static DCPolje getInstance(DCMatrica matrica, Long poljeId, Long vrednost, DCKolona kolona, DCRed red) {
        DCPolje newPolje = new DCPolje(matrica, poljeId, vrednost, kolona, red);
        if (polja.contains(newPolje)) {
            DCPolje existingPolje = polja.get(polja.indexOf(newPolje));
            existingPolje.update(newPolje);
            return existingPolje;
        } else {
            polja.add(newPolje);
            return newPolje;
        }
    }
    
    private DCPolje(DCMatrica matrica, Long poljeId, Long vrednost, DCKolona kolona, DCRed red) {
        this.matrica = matrica;
        this.poljeId = poljeId;
        this.vrednost = vrednost;
        this.kolona = kolona;
        this.red = red;
    }

    private DCPolje(DCMatrica matrica, Long poljeId) {
        this.matrica = matrica;
        this.poljeId = poljeId;
    }

    public DCPolje(DCMatrica matrica) {
        this.matrica = matrica;
    }

    


    public DCMatrica getMatrica() {
        return matrica;
    }

    public void setMatrica(DCMatrica matrica) {
        this.matrica = matrica;
    }

    public Long getPoljeId() {
        return poljeId;
    }

    public void setPoljeId(Long poljeId) {
        this.poljeId = poljeId;
    }

    public Long getVrednost() {
        return vrednost;
    }

    public void setVrednost(Long vrednost) {
        this.vrednost = vrednost;
    }

    public DCKolona getKolona() {
        return kolona;
    }

    public void setKolona(DCKolona kolona) {
        this.kolona = kolona;
    }

    public DCRed getRed() {
        return red;
    }

    public void setRed(DCRed red) {
        this.red = red;
    }

    @Override
    public String getAtrValue() {
        return matrica.getIgra().getIgraId() + ","
                + matrica.getMatricaId() + ","
                + poljeId + ","
                + vrednost + ","
                + kolona.getKolonaId() + ","
                + red.getRedId();
    }

    @Override
    public String setAtrValue() {
        return Constants.Polje.IGRA_ID_FK + "=" + matrica.getIgra().getIgraId() + ","
                + Constants.Polje.MATRICA_ID_FK + "=" + matrica.getMatricaId() + ","
                + Constants.Polje.POLJE_ID + "=" + poljeId + ","
                + Constants.Polje.VREDNOST + "=" + vrednost + ","
                + Constants.Polje.KOLONA_ID_FK + "=" + kolona.getKolonaId() + ","
                + Constants.Polje.RED_ID_FK + "=" + red.getRedId();
    }

    @Override
    public String getClassName() {
        return Constants.Polje.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return Constants.Polje.IGRA_ID_FK + ","
                + Constants.Polje.MATRICA_ID_FK + ","
                + Constants.Polje.POLJE_ID + ","
                + Constants.Polje.VREDNOST + ","
                + Constants.Polje.KOLONA_ID_FK + ","
                + Constants.Polje.RED_ID_FK;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Polje.IGRA_ID_FK + "=" + matrica.getIgra().getIgraId() + " AND "
                + Constants.Polje.MATRICA_ID_FK + "=" + matrica.getMatricaId() + " AND "
                + Constants.Polje.POLJE_ID + "=" + poljeId;
    }

    @Override
    public String getNameByColumn(int column) {
        return new String[]{Constants.Polje.IGRA_ID_FK,
            Constants.Polje.MATRICA_ID_FK,
            Constants.Polje.POLJE_ID,
            Constants.Polje.VREDNOST,
            Constants.Polje.KOLONA_ID_FK,
            Constants.Polje.RED_ID_FK}[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        System.out.println("Checking constratins for Polje");
    }

    @Override
    public void setKey(ResultSet rs) throws Exception {
     try {
            if (rs.next()) {
                poljeId = rs.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("The key was not returned");
        }
    }

    @Override
    public String[] getColumns() {
        return new String[]{Constants.Polje.IGRA_ID_FK, 
            Constants.Polje.MATRICA_ID_FK, 
            Constants.Polje.POLJE_ID, 
            Constants.Polje.VREDNOST, 
            Constants.Polje.KOLONA_ID_FK, 
            Constants.Polje.RED_ID_FK};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Polje.IGRA_ID_FK:
                return matrica.getIgra();
            case Constants.Polje.MATRICA_ID_FK:
                return matrica;
            case Constants.Polje.POLJE_ID:
                return poljeId;
            case Constants.Polje.VREDNOST:
                return vrednost;
            case Constants.Polje.KOLONA_ID_FK:
                return kolona;
            case Constants.Polje.RED_ID_FK:
                return red;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String [] {Constants.Polje.IGRA_ID_FK,Constants.Polje.MATRICA_ID_FK,Constants.Polje.POLJE_ID};
    }

    @Override
    public String getParentWhere() {
        return Constants.Polje.IGRA_ID_FK + "=" + matrica.getIgra().getIgraId() + " AND "
                + Constants.Polje.MATRICA_ID_FK + "=" + matrica.getMatricaId();
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.matrica);
        hash = 71 * hash + Objects.hashCode(this.poljeId);
        hash = 71 * hash + Objects.hashCode(this.vrednost);
        hash = 71 * hash + Objects.hashCode(this.kolona);
        hash = 71 * hash + Objects.hashCode(this.red);
        return hash;
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
        final DCPolje other = (DCPolje) obj;
        if (!Objects.equals(this.matrica, other.matrica)) {
            return false;
        }
        if (!Objects.equals(this.poljeId, other.poljeId)) {
            return false;
        }
        return true;
    }

    @Override
    public void setValue(String column, ResultSet rs, GeneralDObject gdo) {
        try {
            switch(column){
                case Constants.Polje.IGRA_ID_FK:
                    break;
                case Constants.Polje.MATRICA_ID_FK:
                    matrica = DCMatrica.getInstance(rs.getLong(Constants.Matrica.IGRA_ID_FK),rs.getLong(column));
                    break;
                case Constants.Polje.POLJE_ID:
                    poljeId = rs.getLong(column);
                    break;
                case Constants.Polje.VREDNOST:
                    vrednost = rs.getLong(column);
                    break;
                case Constants.Polje.KOLONA_ID_FK:
                    kolona = DCKolona.getInstance(rs.getLong(column));
                    break;
                case Constants.Polje.RED_ID_FK:
                    red = DCRed.getInstance(rs.getLong(column));
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GeneralDObject gdo) {
        vrednost = ((DCPolje)gdo).getVrednost();
        red = ((DCPolje)gdo).getRed();
        kolona = ((DCPolje)gdo).getKolona();
     }

    @Override
    public GeneralDObject getInstance(ResultSet rs) {
            try {
                return getInstance(rs.getLong(Constants.Polje.IGRA_ID_FK),rs.getLong(Constants.Polje.MATRICA_ID_FK),rs.getLong(Constants.Polje.POLJE_ID));
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
    }

    
}
