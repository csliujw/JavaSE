package tij.chapter9;

// 将一个类的接口变成客户端所期待的另一种接口，从而使原本不匹配而无法在一起工作的两个类可以在一起工作。
public class Adapter {
    public static void main(String[] args) {

    }
}

interface SDCard {
    String readSD();

    void writeSD(String msg);
}

class SDCardImpl implements SDCard {

    @Override
    public String readSD() {
        return "sd card";
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("sd write " + msg);
    }
}

class Computer {
    public String readSD(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("sd is null");
        }
        return sdCard.readSD();
    }
}

interface TFCard {
    String readTF();

    void writeTF(String msg);
}

class TFCardImpl implements TFCard {

    @Override
    public String readTF() {
        return "TF read";
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("tf write " + msg);
    }
}

// 把 TF 的功能用 SD 包起来即可
class SDAdapterTF extends TFCardImpl implements SDCard {

    @Override
    public String readSD() {
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        writeTF(msg);
    }
}