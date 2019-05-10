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
public class DCKolona implements GeneralDObject, Serializable {
    
    static List<DCKolona> kolone = new ArrayList<>();

    private Long kolonaId;
    private String naziv;
    private String customWhereCondition;


    @Override
    public String getCustomWhereCondition() {
        return customWhereCondition;
    }

    public void setCustomWhereCondition(String customWhereCondition) {
        this.customWhereCondition = customWhereCondition;
    }
    
    public static DCKolona getInstance() {
        DCKolona newKolona = new DCKolona(0L);
        if (kolone.contains(newKolona)) {
            return kolone.get(kolone.indexOf(newKolona));
        } else {
            kolone.add(newKolona);
            return newKolona;
        }

    }

    public static DCKolona getInstance(Long kolonaId) {
        DCKolona newIgra = new DCKolona(kolonaId);
        if (kolone.contains(newIgra)) {
            return kolone.get(kolone.indexOf(newIgra));
        } else {
            kolone.add(newIgra);
            return newIgra;
        }
    }

    public static DCKolona getInstance(Long kolonaId, String naziv) {
        DCKolona newKolona = new DCKolona(kolonaId, naziv);
        if (kolone.contains(newKolona)) {
            DCKolona existingKolona = kolone.get(kolone.indexOf(newKolona));
            existingKolona.update(newKolona);
            return existingKolona;
        } else {
            kolone.add(newKolona);
            return newKolona;
        }
    }

    private DCKolona(Long kolonaId) {
        this.kolonaId = kolonaId;
    }

    private DCKolona(Long kolonaId, String naziv) {
        this.kolonaId = kolonaId;
        this.naziv = naziv;
    }

    @Override
    public String getAtrValue() {
        return "'" + naziv + "'";
    }

    @Override
    public String setAtrValue() {
        return Constants.Kolona.NAZIV + "='" + naziv + "'";
    }

    @Override
    public String getClassName() {
        return Constants.Kolona.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return Constants.Kolona.BROJ + "," + Constants.Kolona.NAZIV;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Kolona.KOLONA_ID + "=" + kolonaId;
    }

    @Override
    public String getNameByColumn(int column) {
        return new String[]{Constants.Kolona.KOLONA_ID, Constants.Kolona.BROJ, Constants.Kolona.NAZIV}[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        System.out.println("Checking constratints for Kolona");
    }

    @Override
    public void setKey(ResultSet rs) throws Exception {
        try {
            if (rs.next()) {
                kolonaId = rs.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("The key was not returned");
        }
    }

    @Override
    public String[] getColumns() {
        return new String[]{Constants.Kolona.KOLONA_ID, Constants.Kolona.BROJ, Constants.Kolona.NAZIV};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Kolona.KOLONA_ID:
                return kolonaId;
            case Constants.Kolona.NAZIV:
                return naziv;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Kolona.KOLONA_ID};
    }

    public Long getKolonaId() {
        return kolonaId;
    }

    public void setKolonaId(Long kolonaId) {
        this.kolonaId = kolonaId;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.kolonaId);
        hash = 31 * hash + Objects.hashCode(this.naziv);
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
        final DCKolona other = (DCKolona) obj;
        if (!Objects.equals(this.kolonaId, other.kolonaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DCKolona{" + "kolonaId=" + kolonaId + ", naziv=" + naziv + '}';
    }

    @Override
    public void setValue(String column, ResultSet rs, GeneralDObject gdo) {
        try {
            switch (column) {
                case Constants.Kolona.KOLONA_ID: 
                    kolonaId = rs.getLong(column);
                    break;
                case Constants.Kolona.NAZIV:
                    naziv = rs.getString(column);
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void update(GeneralDObject gdo) {
        naziv = ((DCKolona)gdo).getNaziv();
    }

    @Override
    public GeneralDObject getInstance(ResultSet rs) {
        try {
            return getInstance(rs.getLong(Constants.Kolona.KOLONA_ID));
        } catch (SQLException ex){ 
            ex.printStackTrace();
            return null;
        }
    }

}
