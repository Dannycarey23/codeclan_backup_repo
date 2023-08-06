package device_management;

import behaviours.IOutput;

public class Monitor extends VideoDevice implements IOutput {
    public Monitor(int screenSize, int pixels) {
        super(screenSize, pixels);
    }

    public String outputData(String data) {
        return display(data);
    }
}
