
public class Bewerking {
    private int resultaat;
    private String linkeroperand;
    private String operator;
    private String rechteroperand;

    public Bewerking(String bewerking) {
        bewerking = bewerking.replaceAll(" ", "");

        String laatstestuk = bewerking.substring(1);
        int indexMin = laatstestuk.indexOf('-');
        int indexPlus = laatstestuk.indexOf('+');
        int indexMaal = laatstestuk.indexOf('*');
        int indexDeling = laatstestuk.indexOf('/');
        if (indexMaal != -1) {
            operator = "*";
        } else if (indexDeling != -1) {
            operator = "/";
        } else if (indexMin != -1) {
            operator = "-";
        } else if (indexPlus != -1) {
            operator = "+";
        }
        int operatorIndex = laatstestuk.indexOf(operator) + 1;
        linkeroperand = bewerking.substring(0, operatorIndex);
        rechteroperand = bewerking.substring(operatorIndex + 1);
        //System.out.println(operator);
        //System.out.println(linkerOperand);
        //System.out.println(rechterOperand);
        switch (operator) {
            case "-":
                resultaat = Integer.parseInt(linkeroperand) - Integer.parseInt(rechteroperand);
                break;
            case "+":
                resultaat = Integer.parseInt(linkeroperand) + Integer.parseInt(rechteroperand);
                break;
            case "*":
                resultaat = Integer.parseInt(linkeroperand) * Integer.parseInt(rechteroperand);
                break;
            case "/":
                resultaat = Integer.parseInt(linkeroperand) / Integer.parseInt(rechteroperand);
                break;
        }

    }

    public Bewerking(String linkeroperand, String operator, String rechteroperand) {
        this.linkeroperand = linkeroperand.trim();
        this.rechteroperand = rechteroperand.trim();
        this.operator = operator.trim();
        switch (this.operator) {
            case "-":
                resultaat = Integer.parseInt(this.linkeroperand) - Integer.parseInt(this.rechteroperand);
                break;
            case "+":
                resultaat = Integer.parseInt(this.linkeroperand) + Integer.parseInt(this.rechteroperand);
                break;
            case "*":
                resultaat = Integer.parseInt(this.linkeroperand) * Integer.parseInt(this.rechteroperand);
                break;
            case "/":
                resultaat = Integer.parseInt(this.linkeroperand) / Integer.parseInt(this.rechteroperand);
                break;
        }
    }

    public int oplossing() {
        return resultaat;
    }

    @Override
    public String toString() {
        return linkeroperand + " " + operator + " " + rechteroperand + " = ";
    }

    public String toStringMetOplossing() {
        return toString() + resultaat;
    }
}
