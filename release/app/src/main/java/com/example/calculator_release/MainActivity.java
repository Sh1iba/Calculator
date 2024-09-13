package com.example.calculator_release;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our text view and button
    private TextView tvsec,tvMain;
    private Button bac,bc,left_bracket,right_bracket,bsin,bcos,btan,blog,bln;
    private Button bfact,bsquare,bsqrt,binv;
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private Button bpi,bmul,bminus,bplus,bequal,bdot,bdiv;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        tvsec = findViewById(R.id.idTVSecondary);//отображение названия приложения
        tvMain = findViewById(R.id.idTVprimary);//Вывод выражения на экран
        bac = findViewById(R.id.bac);//
        bc = findViewById(R.id.bc);//
        left_bracket = findViewById(R.id.left_bracket);//
        right_bracket = findViewById(R.id.right_bracket);//
        bsin = findViewById(R.id.bsin);//
        bcos = findViewById(R.id.bcos);//
        btan = findViewById(R.id.btan);//
        blog = findViewById(R.id.blog);//
        bln = findViewById(R.id.bln);//
        bfact = findViewById(R.id.bfact);//
        bsquare = findViewById(R.id.bsquare);//
        bsqrt = findViewById(R.id.bsqrt);//
        binv = findViewById(R.id.binv);//
        b0 = findViewById(R.id.b0);//
        b9 = findViewById(R.id.b9);//
        b8 = findViewById(R.id.b8);//
        b7 = findViewById(R.id.b7);//
        b6 = findViewById(R.id.b6);//
        b5 = findViewById(R.id.b5);//
        b4 = findViewById(R.id.b4);//
        b3 = findViewById(R.id.b3);//
        b2 = findViewById(R.id.b2);//
        b1 = findViewById(R.id.b1);//
        bpi = findViewById(R.id.bpi);//
        bmul = findViewById(R.id.bmul);//
        bminus = findViewById(R.id.bminus);//
        bplus = findViewById(R.id.bplus);//
        bequal = findViewById(R.id.bequal);//
        bdot = findViewById(R.id.bdot);//
        bdiv = findViewById(R.id.bdiv);//

        // adding on click listener to our all buttons.
        b1.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "1"));
        b2.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "2"));
        b3.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "3"));
        b4.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "4"));
        b5.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "5"));
        b6.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "6"));
        b7.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "7"));
        b8.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "8"));
        b9.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "9"));
        b0.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "0"));
        bdot.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "."));
        bplus.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "+"));
        bdiv.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "/"));
        left_bracket.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "("));
        right_bracket.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + ")"));
        bpi.setOnClickListener(v -> {
            tvMain.setText(tvMain.getText().toString() + "3.142");
            tvsec.setText(bpi.getText().toString());
        });
        bsin.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "sin"));
        bcos.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "cos"));
        btan.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "tan"));
        binv.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "^" + "(-1)"));
        bln.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "ln"));
        blog.setOnClickListener(v -> tvMain.setText(tvMain.getText().toString() + "log"));

        bminus.setOnClickListener(v -> {
            String str = tvMain.getText().toString();
            if (!str.substring(str.length() - 1).equals("-")) {
                tvMain.setText(tvMain.getText().toString() + "-");
            }
        });
        bmul.setOnClickListener(v -> {
            String str = tvMain.getText().toString();
            if (!str.substring(str.length() - 1).equals("*")) {
                tvMain.setText(tvMain.getText().toString() + "*");
            }
        });
        bsqrt.setOnClickListener(v -> {
            if (tvMain.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show();
            } else {
                String str = tvMain.getText().toString();
                double r = Math.sqrt(Double.parseDouble(str));
                tvMain.setText(String.valueOf(r));
            }
        });
        bequal.setOnClickListener(v -> {
            String str = tvMain.getText().toString();
            double result = evaluate(str);
            tvMain.setText(String.valueOf(result));
            tvsec.setText(str);
        });
        bac.setOnClickListener(v -> {
            tvMain.setText("");
            tvsec.setText("");
        });
        bc.setOnClickListener(v -> {
            String str = tvMain.getText().toString();
            if (!str.equals("")) {
                str = str.substring(0, str.length() - 1);
                tvMain.setText(str);
            }
        });
        bsquare.setOnClickListener(v -> {
            if (tvMain.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show();
            } else {
                double d = Double.parseDouble(tvMain.getText().toString());
                double square = d * d;
                tvMain.setText(String.valueOf(square));
                tvsec.setText(d + "²");
            }
        });
        bfact.setOnClickListener(v -> {
            if (tvMain.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show();
            } else {
                int value = Integer.parseInt(tvMain.getText().toString());
                int fact = factorial(value);
                tvMain.setText(String.valueOf(fact));
                tvsec.setText(value + "`!");
            }
        });
    }

    private int factorial(int n) {
        // this method is use to find factorial
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }

    private double evaluate(String str) {
        return new Object() {
            // on below line we are creating variable
            // for tracking the position and char pos.
            private int pos = -1;
            private int ch = 0;

            // below method is for moving to next character.
            private void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            // this method is use to check the extra space
            // present in the expression and removing it.
            private boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            // below method is to parse our
            // expression and to get the ans
            // in this we are calling a parse
            // expression method to calculate the value.
            private double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // in this method we will only perform addition and
            // subtraction operation on the expression.
            private double parseExpression() {
                double x = parseTerm();
                while (true) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            // in below method we will perform
            // only multiplication and division operation.
            private double parseTerm() {
                double x = parseFactor();
                while (true) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            // below method is use to parse the factor
            private double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus
                double x;
                int startPos = pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if (ch >= '0' && ch <= '9' || ch == '.') {
                    while (ch >= '0' && ch <= '9' || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
                return x;
            }
        }.parse();
    }
}