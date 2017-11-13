import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

import static java.lang.Class.*;

public class Register extends HttpServlet
{
    Connection cn;
    PreparedStatement ps;
//    Statement s;
    public void init()
    {
        try{
            forName("oracle.jdbc.driver.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
ps=cn.prepareStatement("Insert into table1 values(?,?,?,?,?)");
//s=cn.createStatement();

//ps=cn.prepareStatement(" Select * from admin where name = (?) and pass = (?)");
        }catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();

        try{

            String roll=req.getParameter("t1");
            String regd=req.getParameter("t2");
            String branch=req.getParameter("t3");
            String hobbies=req.getParameter("t4");
            String phno=req.getParameter("t5");


ps.setString(1,roll);
ps.setString(2,regd);
ps.setString(3,branch);
ps.setString(4,hobbies);
ps.setString(5,phno);


//ps.executeUpdate();
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
               out.println("Successfully Inserted");
                RequestDispatcher rd2=req.getRequestDispatcher("register.html");
                rd2.include(req,res);

            }else{

                out.println("<center>Error .................");
                out.println("<br>Please Enter Again");


                RequestDispatcher rd=req.getRequestDispatcher("register.html");
                rd.include(req,res);
            }
        }catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }

}





