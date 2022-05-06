package ua.com.test;

public class Memory {
    private int position = 0;
    private final int LENGTH = 30000;
    private byte[] bytes = new byte[LENGTH];

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public byte[] getBytes() {
        return bytes;
    }
}
