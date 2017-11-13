import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class Update extends HttpServlet
{
    Connection cn;
    PreparedStatement ps;
    //Statement s;
    public void init()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
//ps=cn.prepareStatement("Insert into stud11 values(?,?,?,?,?,?,?,?,?)");
//s=cn.createStatement();
            ps=cn.prepareStatement("Select * from table1 where roll=(?)");
//ps=cn.prepareStatement("UPDATE stud11 SET names=(?),gender=(?),dob=(?),addr=(?),contact=(?),doj=(?),branch=(?),yr=(?) where regd=(?)");
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
/*
String t2=req.getParameter("t2");
String t3=req.getParameter("t3");
String t4=req.getParameter("t4");
String t5=req.getParameter("t5");
String t6=req.getParameter("t6");
String t7=req.getParameter("t7");
String t8=req.getParameter("t8");
String t9=req.getParameter("t9");







ps.setString(1,t2);
ps.setString(2,t3);
ps.setString(3,t4);
ps.setString(4,t5);
ps.setString(5,t6);
ps.setString(6,t7);
ps.setString(7,t8);
ps.setString(8,t9);
ps.setString(9,t1);

*/
            ps.setString(1,t1);
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            String s[]=new String[5];

            if(rs.next())
            {
                int i=rsmd.getColumnCount();
                int h=1;
                int j=0;

                while(h<=i)
                {
                    s[j]=rs.getString(h);
                    h++;
                    j++;
                }
                out.println("<html><head></head><body><form action='update2'><center><table border=1px><tr><td>Roll-</td><td><input type='text' value='"+s[0]+"' name='t1'></td></tr><tr><td>Registration No-</td><td><input type='text'value='"+s[1]+"' name='t2'></td></tr>");
                out.println("<tr><td>Branch-</td><td><input type='text' name='t3' value='"+s[2]+"'></td></tr><tr><td>Hobbies-</td><td><input type='text' name='t4' value='"+s[3]+"'></td></tr><tr><td>Phone No-</td><td><input type='text' name='t5' value='"+s[4]+"'></td></tr></table><center><br><br><input type='submit' value='CLick Me'></form></body></html>");












            }else{
                out.println("Please Renter the data");

                RequestDispatcher rd=req.getRequestDispatcher("updatebook.html");
                rd.include(req,res);
            }
        }catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }

}





