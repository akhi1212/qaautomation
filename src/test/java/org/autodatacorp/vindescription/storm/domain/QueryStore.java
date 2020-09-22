package org.autodatacorp.vindescription.storm.domain;

public class QueryStore {


    public String getVehSummaryQuery() {
        return "select styleid, lastupdated, vehsummaryresponse FROM vindescriptionlookup.vindescriptiondetails WHERE styleid in ( ) ORDER BY effectiveDate desc limit 1";
    }

    public String deleteVehSummaryByStle(){
        return "DELETE FROM vindescriptionlookup.vindescriptiondetails WHERE styleid in (";
    }


}
