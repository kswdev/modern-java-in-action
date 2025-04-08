package chapter10._3_java_dsl_pattern.method_reference.calculator.classic;

import chapter10._3_java_dsl_pattern.model.Order;
import chapter10._3_java_dsl_pattern.model.Tax;

public class TaxClassicCalculator {
    private boolean useRegional;
    private boolean useGeneral;
    private boolean useSurcharge;

    public TaxClassicCalculator withTaxRegional() {
        this.useRegional = true;
        return this;
    }

    public TaxClassicCalculator withTaxGeneral() {
        this.useGeneral = true;
        return this;
    }

    public TaxClassicCalculator withTaxSurcharge() {
        this.useSurcharge = true;
        return this;
    }

    public double calculate(Order order) {
        return Tax.calculate(order, useRegional, useGeneral, useSurcharge);
    }
}