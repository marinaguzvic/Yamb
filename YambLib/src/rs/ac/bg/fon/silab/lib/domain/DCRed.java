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
public class DCRed implements GeneralDObject, Serializable {

    static List<DCRed> redovi = new ArrayList<>();
    private Long redId;
    private String naziv;

    private String customWhereCondition;

    @Override
    public String getCustomWhereCondition() {
        return customWhereCondition;
    }

    public void setCustomWhereCondition(String customWhereCondition) {
        this.customWhereCondition = customWhereCondition;
    }

    public static DCRed getInstance() {
        DCRed newRed = new DCRed(0L);
        if (redovi.contains(newRed)) {
            return redovi.get(redovi.indexOf(newRed));
        } else {
            redovi.add(newRed);
            return newRed;
        }

    }

    public static DCRed getInstance(Long redId) {
        DCRed newPolje = new DCRed(redId);
        if (redovi.contains(newPolje)) {
            return redovi.get(redovi.indexOf(newPolje));
        } else {
            redovi.add(newPolje);
            return newPolje;
        }
    }

    public static DCRed getInstance(Long redId, String naziv) {
        DCRed newRed = new DCRed(redId, naziv);
        if (redovi.contains(newRed)) {
            DCRed existingRed = redovi.get(redovi.indexOf(newRed));
            existingRed.update(newRed);
            return existingRed;
        } else {
            redovi.add(newRed);
            return newRed;
        }
    }

    private DCRed(Long redId) {
        this.redId = redId;
    }

    private DCRed(Long redId, String naziv) {
        this.redId = redId;
        this.naziv = naziv;
    }

    @Override
    public String getAtrValue() {
        return "'" + naziv + "'";
    }

    @Override
    public String setAtrValue() {
        return Constants.Red.NAZIV + "='" + naziv + "'";
    }

    @Override
    public String getClassName() {
        return Constants.Red.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return Constants.Red.BROJ + "," + Constants.Red.NAZIV;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Red.RED_ID + "=" + redId;
    }

    @Override
    public String getNameByColumn(int column) {
        return new String[]{Constants.Red.RED_ID, Constants.Red.BROJ, Constants.Red.NAZIV}[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        System.out.println("Checking constratints for Red");
    }

    @Override
    public void setKey(ResultSet rs) throws Exception {
        try {
            if (rs.next()) {
                redId = rs.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("The key was not returned");
        }
    }

    @Override
    public String[] getColumns() {
        return new String[]{Constants.Red.RED_ID, Constants.Red.BROJ, Constants.Red.NAZIV};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Red.RED_ID:
                return redId;
            case Constants.Red.NAZIV:
                return naziv;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Red.RED_ID};
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getRedId() {
        return redId;
    }

    public void setRedId(Long redId) {
        this.redId = redId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.redId);
        hash = 83 * hash + Objects.hashCode(this.naziv);
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
        final DCRed other = (DCRed) obj;
        if (!Objects.equals(this.redId, other.redId)) {
            return false;
        }
        return true;
    }

    @Override
    public void setValue(String column, ResultSet rs, GeneralDObject gdo) {
        try {
            switch (column) {
                case Constants.Red.RED_ID:
                    redId = rs.getLong(column);
                    break;
                case Constants.Red.NAZIV:
                    naziv = rs.getString(column);
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void update(GeneralDObject gdo) {
        naziv = ((DCRed) gdo).getNaziv();
    }

    @Override
    public GeneralDObject getInstance(ResultSet rs) {
        try {
            return getInstance(rs.getLong(Constants.Red.RED_ID));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
