package com.home;

public class MeasurableAdapterImp implements MeasurableAdapter {
    private Measurable measurable;

    public MeasurableAdapterImp(Measurable measurable) {
        this.measurable = measurable;
    }

    @Override
    public double getArea() {
        return convertFt2ToMeter2(measurable.getArea());
    }

    private double convertFt2ToMeter2(double ft2){
        return ft2 * 0.092903;
    }
}
