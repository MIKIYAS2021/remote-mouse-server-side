import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GUIforServer extends JFrame
{
    private boolean ipConnect=true;
    private  String disp;
    private ImageIcon image;
    private JLabel toplabel;
    private JButton connect, disconnect,reload;
    private JLabel ipDisp;
    public GUIforServer() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        disp = ip.getHostAddress();

        reload = new JButton("RELOAD");
        reload.setFocusable(false);
        reload.setFont(new Font("Calibri",Font.PLAIN,30));
        reload.setBounds(600,150,200,40);
        reload.addActionListener(new ActionPerformer());

        connect = new JButton("CONNECT");
        connect.setFocusable(false);
        connect.setFont(new Font("Calibri",Font.PLAIN,40));
        connect.setBounds(100,350,250,50);
        connect.addActionListener(new ActionPerformer());

        disconnect = new JButton("DISCONNECT");
        disconnect.setFont(new Font("Calibri",Font.PLAIN,40));
        disconnect.setFocusable(false);
        disconnect.setBounds(400,350,250,50);
        disconnect.addActionListener(new ActionPerformer());

        ipDisp = new JLabel("the ip of the computer is "+disp);
        ipDisp.setBounds(0,150,800,50);
        ipDisp.setFont(new Font("Calibri",Font.PLAIN,30));

        toplabel = new JLabel("Mouse Controller");
        toplabel.setFont(new Font("Forte",Font.BOLD,50));
        toplabel.setBounds(50,50,700,60);
        Container con = getContentPane();
        image = new ImageIcon(new ImageIcon("mouse.png").getImage().getScaledInstance(
                60,60,Image.SCALE_SMOOTH));
        toplabel.setIcon(image);



        con.setLayout(null);
        con.add(toplabel);
        con.add(connect);
        con.add(disconnect);
        con.add(ipDisp);
        con.add(reload);
        setResizable(false);
        con.setBackground(new Color(0x84a5db));

        setIconImage(image.getImage());
        setTitle("Mouse Controller");
        setSize(800,500);
        setLocation(200,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void setIpConnect(boolean ipConnect)
    {
        this.ipConnect=ipConnect;
    }
    public boolean getIpConnect()
    {
        return ipConnect;
    }

    private class ActionPerformer implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==reload)
            {
                InetAddress ip = null;
                try {
                    ip = InetAddress.getLocalHost();
                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                }
                disp = ip.getHostAddress();
                ipDisp.setText("");
                ipDisp.setText("the ip of the computer is "+disp);
            }
            else if(e.getSource()==connect)
            {
                ipConnect = true;
                setIpConnect(ipConnect);
            }
            else if(e.getSource()==disconnect)
            {
                ipConnect = false;
                setIpConnect(ipConnect);
            }

        }
    }

}
