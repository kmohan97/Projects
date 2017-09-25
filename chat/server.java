//using datagrampacket and DatagramSocket


import java.util.*;
import java.net.*;
public class server
{
public static DatagramSocket ds;
public static int clientport=9999,serverport=10000;
public static void main(String args[])
{
try{
Scanner ss=new Scanner(System.in);
byte buffer[]=new byte[2300];
byte buffer1[]=new byte[2300];

System.out.println("Enter TExt");
ds=new DatagramSocket(serverport);
InetAddress ia=InetAddress.getByName("localhost");
while(true)
{
String s=ss.nextLine();
if(s.equals("end"))
	break;
s=s+" "+ia.getHostAddress()+" "+ia.getHostName();
buffer=s.getBytes();
ds.send(new DatagramPacket(buffer,buffer.length,ia,clientport));



DatagramPacket dp1=new DatagramPacket(buffer1,buffer1.length);
ds.receive(dp1);
String s1=new String(dp1.getData(),0,dp1.getLength());
System.out.println(s1);


}
}catch(Exception e)
{
e.printStackTrace();
}
}
}
	
