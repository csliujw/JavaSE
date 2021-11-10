package tij.chapter10;

public class Parcel {
    private class PContents implements Contents {
        @Override
        public void values() {
            System.out.println("1231312");
        }
    }

    public Contents createContents() {
        return new PContents();
    }

    public static void main(String[] args) {
        Contents con = new Parcel().createContents();
        con.values();
    }
}
