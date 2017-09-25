import java.util.*;
import java.net.*;
public class client
{
public static DatagramSocket ds;
public static int clientport=9999,serverport=10000;
public static void main(String args[])
{
try{
Scanner ss=new Scanner(System.in);
byte buffer[]=new byte[2300];
byte buffer1[]=new byte[2300];
System.out.println("Waiting for server to send");
ds=new DatagramSocket(clientport);
InetAddress ia=InetAddress.getByName("localhost");
while(true)
{
DatagramPacket dp=new DatagramPacket(buffer,buffer.length);
ds.receive(dp);
String s1=new String(dp.getData(),0,dp.getLength());
System.out.println(s1);

String s=ss.nextLine();
if(s.equals("end"))
	break;
s=s+"  "+ia.getHostAddress()+" "+ia.getHostName();
buffer1=s.getBytes();
ds.send(new DatagramPacket(buffer1,buffer1.length,ia,serverport));

}
}catch(Exception e)
{
e.printStackTrace();
}
}
}
	