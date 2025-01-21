package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;

public class CimEncoderForDrivetrain {
    // Initializes an encoder on DIO pins 0 and 1
    // 2X encoding and non-inverted
    Encoder encoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);

    public CimEncoderForDrivetrain() {
        // Configures the encoder to return a distance of 4 for every 256 pulses
    // Also changes the units of getRate
    encoder.setDistancePerPulse(4.0/256.0);
    // Configures the encoder to consider itself stopped when its rate is below 10
    encoder.setMinRate(10);
    // Reverses the direction of the encoder
    encoder.setReverseDirection(true);
    // Configures an encoder to average its period measurement over 5 samples
    // Can be between 1 and 127 samples
    encoder.setSamplesToAverage(5);
    }

    // Gets the distance traveled
    public double getDistance() {
        return encoder.getDistance();
    }

    // Gets the current rate of the encoder
    public double getRate() {
        return encoder.getRate();
    }

    // Gets whether the encoder is stopped
    public boolean getStopped() {
        return encoder.getStopped();
    }

    // Gets the last direction in which the encoder moved
    public boolean getDirection () {
        return encoder.getDirection();
    }

    // Resets the encoder to read a distance of zero
    public void reset() {
        encoder.reset();
    }
 
}
