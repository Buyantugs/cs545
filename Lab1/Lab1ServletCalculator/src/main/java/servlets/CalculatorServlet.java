package servlets;

import model.Calculator;
import model.MyObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

    List<MyObject> listCalc=new ArrayList<>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show calculator page
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>SIMPLE CALCULATOR<br><br><br></head>");
        out.println("<body>");
        out.println("<form method = 'post' action = 'calc'>");
        out.println("enter the first number:<br>");
        out.println("<input type = 'text' name='number1'><br><br>");
        out.println("enter the second number:<br>");
        out.println("<input type = 'text' name='number2'><br><br>");
        out.println("enter the operation:<br><br>");
        out.println("<input type ='radio' name = 'op' value = '+'>add<br>");
        out.println("<input type = 'radio' name = 'op' value = '-'>sub<br>");
        out.println("<input type = 'radio' name = 'op' value = '*'>mul<br>");
        out.println("<input type = 'radio' name = 'op' value = '/'>div<br><br>");
        out.println("<input type = 'submit' name = 'result' value = 'submit'><br>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

    public boolean isNumberic(String input){
        return input != null && input.matches("-?\\d+(\\.\\d+)?");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show result page
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>SIMPLE CALCULATOR<br><br><br></head>");
        out.println("<body>");
        out.println("<form method = 'post' action = 'calc'>");
        out.println("enter the first number:<br>");
        out.println("<input type = 'text' name='number1'><br><br>");
        out.println("enter the second number:<br>");
        out.println("<input type = 'text' name='number2'><br><br>");
        out.println("enter the operation:<br><br>");
        out.println("<input type ='radio' name = 'op' value = '+'>add<br>");
        out.println("<input type = 'radio' name = 'op' value = '-'>sub<br>");
        out.println("<input type = 'radio' name = 'op' value = '*'>mul<br>");
        out.println("<input type = 'radio' name = 'op' value = '/'>div<br><br>");
        out.println("<input type = 'submit' name = 'result' value = 'submit'><br>");

        String firstNumber=request.getParameter("number1");
        String secondNumber=request.getParameter("number2");
        String operation=request.getParameter("op");

        String result="";

        HttpSession session=request.getSession();


        if (isNumberic(firstNumber) && isNumberic(secondNumber)) {
            float num1 = Float.parseFloat(firstNumber);
            float num2 = Float.parseFloat(secondNumber);

            result=Calculator.calculate(num1, num2,operation);

            listCalc.add(new MyObject(num1,num2,operation,result));
            session.setAttribute("listCalc",listCalc);

            out.println("<h2> The result of "+firstNumber+" "+operation+" "+secondNumber+" = "+ result +" </h2>");


        }else{
            result="Please input numeric values!";
            out.println("<h2> Result: "+ result +" </h2>");
        }

        List<MyObject> listCalc=(List<MyObject>) session.getAttribute("listCalc");

        out.println("<table border=\"1\">\n" +
                "        <tr>\n" +
                "            <th>First</th>\n" +
                "            <th>Operation</th>\n" +
                "            <th>Second</th>\n" +
                "            <th>result</th>\n" +
                "        </tr>");

        for (MyObject myObject : listCalc) {
            out.println(" <tr> <td>"+myObject.getNum1()+"</td> <td>"+myObject.getOp()+"</td> <td> "+myObject.getNum2()+" </td> <td> "+ myObject.getResult() +" </td> </tr>");
        }

        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

}
