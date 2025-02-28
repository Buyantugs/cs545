package model;

public class MyObject {
    private float num1;
    private float num2;
    private String op;
    private String result;

    public MyObject(float num1, float num2, String op, String result) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
        this.result = result;
    }

    public float getNum1() {
        return num1;
    }

    public float getNum2() {
        return num2;
    }

    public String getOp() {
        return op;
    }

   public String getResult() {
        return result;
    }


}
