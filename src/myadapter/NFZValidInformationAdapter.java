/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myadapter;

import java.util.List;
import nfzManagers.IValidInformation;

/**
 *
 * @author student
 */
public class NFZValidInformationAdapter implements INFZValidInformationAdapter {
    
    private IValidInformation _validInformation;

    @Override
    public String[] GetRefundedListOfDrugs() {
        return (String[]) _validInformation.GetRefundedListOfDrugs().toArray();
    }

    @Override
    public String[] GeListOfMedicalFacility() {
        String[] clinics = _validInformation.GeListOfClinic(null);
        String[] hospitals = _validInformation.GeListOfHospital(null);
        String[] merge = new String[clinics.length + hospitals.length];
        
        System.arraycopy(clinics, 0, merge, 0, clinics.length);
        System.arraycopy(hospitals, 0, merge, clinics.length, hospitals.length);
        return merge;
    }
    
    public NFZValidInformationAdapter(IValidInformation vi) {
        _validInformation = vi;
    }
}
