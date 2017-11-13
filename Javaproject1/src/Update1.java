import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

import static java.lang.Class.*;

public class Update1 extends HttpServlet
{
    Connection cn;
    PreparedStatement ps;
    //    Statement s;
    public void init()
    {
        try{
            forName("oracle.jdbc.driver.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            ps=cn.prepareStatement("UPDATE table1 SET regd=(?),branch=(?),hobbies=(?),phno=(?) where roll=(?)");
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


            ps.setString(5,roll);
            ps.setString(1,regd);
            ps.setString(2,branch);
            ps.setString(3,hobbies);
            ps.setString(4,phno);


//ps.executeUpdate();
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                out.println("Successfully Updated");
                RequestDispatcher rd2=req.getRequestDispatcher("update.html");
                rd2.include(req,res);

            }else{

                out.println("<center>Error .................");
                out.println("<br>Please Enter Again");


                RequestDispatcher rd=req.getRequestDispatcher("update.html");
                rd.include(req,res);
            }
        }catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }

}





