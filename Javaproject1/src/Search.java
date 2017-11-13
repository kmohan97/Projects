import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class Search extends HttpServlet
{
    Connection cn;
    PreparedStatement ps;
  //  Statement s;
    public void init()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");

            ps=cn.prepareStatement(" Select * from table1 where roll=(?)");
//s=cn.createStatement();
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
            String t1=req.getParameter("t1");

//ps.setString(1,t1);


//ResultSet rs=s.executeQuery("Select * from stud11 where regd='" +t1+ "'");
            ps.setString(1,t1);
      //  ps.executeUpdate();
            ResultSet rs=ps.executeQuery();


            ResultSetMetaData rsmd=rs.getMetaData();

            if(rs.next())
            {
                out.println("<html><body>");
                int i=rsmd.getColumnCount();
                int h=1;
                out.println("<table border=1px><tr>");
                while(h<=i)
                {
                    out.println("<td>");

                    out.println(rsmd.getColumnName(h));
                    h++;
                    out.println("</td>");
                }

                out.println("</tr>");



                out.println("<tr>");
                h=1;

                while(h<=i)
                {
                    out.println("<td>");
                    out.println(rs.getString(h));
                    out.println("</td>");
                    h++;
                }

                out.println("</table></div>");
                out.println("</center></body></html>");









            }else{
                out.println("Error...<br>");
                out.println("Please Reenter the Roll Number");
                RequestDispatcher rd=req.getRequestDispatcher("search.html");
                rd.include(req,res);
            }
        }catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }

}





