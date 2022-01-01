package co.com.sofka.model;

import co.com.sofka.util.ClassType;
import co.com.sofka.util.Journey;
import co.com.sofka.util.MonthInfo;
import co.com.sofka.util.MonthSpecs;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static co.com.sofka.util.MonthSpecs.*;
import static co.com.sofka.util.MonthSpecs.DEC_DAYS;

@Data
@NoArgsConstructor
public class DespegarSearchModel {
    private Journey journey;
    private String origin;
    private String destination;
    private String departureDay;
    private MonthInfo departureMonth = new MonthInfo();
    private String departureYear;
    private String returnDay;
    private MonthInfo returnMonth = new MonthInfo();
    private String returnYear;
    private String adults;
    private String children;
    private ClassType classType;
    private List<String> prices;

    public void setMonthInfo(MonthSpecs month, MonthInfo monthToSet){
        switch(month) {
            case JAN:
                monthToSet.setMonth(JAN.getValue());
                monthToSet.setMonthNumber(JAN_NUM.getValue());
                monthToSet.setMonthShort(JAN_SHORT.getValue());
                monthToSet.setMonthDays(JAN_DAYS.getValue());
                break;
            case FEB:
                monthToSet.setMonth(FEB.getValue());
                monthToSet.setMonthNumber(FEB_NUM.getValue());
                monthToSet.setMonthShort(FEB_SHORT.getValue());
                monthToSet.setMonthDays(FEB_DAYS.getValue());
                break;
            case MAR:
                monthToSet.setMonth(MAR.getValue());
                monthToSet.setMonthNumber(MAR_NUM.getValue());
                monthToSet.setMonthShort(MAR_SHORT.getValue());
                monthToSet.setMonthDays(MAR_DAYS.getValue());
                break;
            case APR:
                monthToSet.setMonth(APR.getValue());
                monthToSet.setMonthNumber(APR_NUM.getValue());
                monthToSet.setMonthShort(APR_SHORT.getValue());
                monthToSet.setMonthDays(APR_DAYS.getValue());
                break;
            case MAY:
                monthToSet.setMonth(MAY.getValue());
                monthToSet.setMonthNumber(MAY_NUM.getValue());
                monthToSet.setMonthShort(MAY_SHORT.getValue());
                monthToSet.setMonthDays(MAY_DAYS.getValue());
                break;
            case JUN:
                monthToSet.setMonth(JUN.getValue());
                monthToSet.setMonthNumber(JUN_NUM.getValue());
                monthToSet.setMonthShort(JUN_SHORT.getValue());
                monthToSet.setMonthDays(JUN_DAYS.getValue());
                break;
            case JUL:
                monthToSet.setMonth(JUL.getValue());
                monthToSet.setMonthNumber(JUL_NUM.getValue());
                monthToSet.setMonthShort(JUL_SHORT.getValue());
                monthToSet.setMonthDays(JUL_DAYS.getValue());
                break;
            case AUG:
                monthToSet.setMonth(AUG.getValue());
                monthToSet.setMonthNumber(AUG_NUM.getValue());
                monthToSet.setMonthShort(AUG_SHORT.getValue());
                monthToSet.setMonthDays(AUG_DAYS.getValue());
                break;
            case SEP:
                monthToSet.setMonth(SEP.getValue());
                monthToSet.setMonthNumber(SEP_NUM.getValue());
                monthToSet.setMonthShort(SEP_SHORT.getValue());
                monthToSet.setMonthDays(SEP_DAYS.getValue());
                break;
            case OCT:
                monthToSet.setMonth(OCT.getValue());
                monthToSet.setMonthNumber(OCT_NUM.getValue());
                monthToSet.setMonthShort(OCT_SHORT.getValue());
                monthToSet.setMonthDays(OCT_DAYS.getValue());
                break;
            case NOV:
                monthToSet.setMonth(NOV.getValue());
                monthToSet.setMonthNumber(NOV_NUM.getValue());
                monthToSet.setMonthShort(NOV_SHORT.getValue());
                monthToSet.setMonthDays(NOV_DAYS.getValue());
                break;
            case DEC:
                monthToSet.setMonth(DEC.getValue());
                monthToSet.setMonthNumber(DEC_NUM.getValue());
                monthToSet.setMonthShort(DEC_SHORT.getValue());
                monthToSet.setMonthDays(DEC_DAYS.getValue());
                break;
        }
    }
}
