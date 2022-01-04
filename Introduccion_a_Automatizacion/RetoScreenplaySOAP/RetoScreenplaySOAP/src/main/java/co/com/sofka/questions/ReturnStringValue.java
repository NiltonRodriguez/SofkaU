package co.com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ReturnStringValue implements Question<String> {

    private String systemValue;

    @Override
    public String answeredBy(Actor actor) {
        return systemValue;
    }

    private ReturnStringValue() {
    }

    public ReturnStringValue withSystemValue(String systemValue) {
        this.systemValue = systemValue;
        return this;
    }

    public static ReturnStringValue returnStringValue(){
        return new ReturnStringValue();
    }
}
