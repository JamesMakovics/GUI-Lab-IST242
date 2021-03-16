
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GrossPay extends JFrame implements ActionListener {

    private JFrame f;
    private JTextField idv=null,hoursv=null;
    private  JLabel id=null,hours=null;
    private JButton button=null,clear=null;
    private JLabel error=null;
    JScrollPane pane=null;
    JTable table=null;
    DefaultTableModel model =null;

    public void actionPerformed(ActionEvent e){


    }
    public GrossPay(){
        f = new JFrame("Employee’s Gross Pay Calculator");
        id=new JLabel("Employee ID: ");
        hours=new JLabel("Pay Hours");
        id.setBounds(200,30,120,30);
        hours.setBounds(200,70,120,30);
        idv=new JTextField("");
        hoursv=new JTextField("");
        idv.setBounds(360,30,120,30);
        hoursv.setBounds(360,70,120,30);
        f.getContentPane().setLayout(null);
        f.setSize(800,600);
        f.setVisible(true);


    button = new JButton("Calculate Gross Pay");
        button.setBounds(160,120,150,30);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    File file=new File("C:\\Users\\James\\Documents\\GitHub\\GUI-Lab-IST242\\Employees.txt"); //File path goes here
                    FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    boolean hit=false;
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null)
                            break;
                        String[] data=line.split(",");
                        if(idv.getText()==null||idv.getText().equals(""))
                            throw new Exception("Employee ID is Empty and is Required");
                        if(hoursv.getText()==null||hoursv.getText().equals(""))
                            throw new Exception("Hours Worked is Empty and is Required");
                        if(idv.getText().equals(data[0])){
                            hit=true;
                            String firstName=data[1];
                            String secondName=data[2];

                            Double payrate = Double.parseDouble(data[3]);
                            Double hoursCount = Double.parseDouble(hoursv.getText());
                            Double oT = 0.0;
                            if(hoursCount >= 40.0){
                                oT = hoursCount - 40.0;
                                hoursCount = hoursCount - oT;
                            }
                            Double regPay=hoursCount * payrate;
                            Double oTpay = oT * 1.5 * payrate;
                            Double grossPay = regPay + oTpay;
                            String col[] = {"Employee Id","Employee Name","Regular Hours","OverTime Hours","Regular Pay","OT Pay","GrossPay"};
                            String[][] datas={{idv.getText(),firstName + " " + secondName, hoursCount + "", oT + "", regPay + "", oTpay + "", grossPay + ""}};
                            if(model==null) {
                                model = new DefaultTableModel(datas, col);
                            }
                            if(table==null){
                                table = new JTable();
                                table.setModel(model);}
                            else{
                                model.setDataVector(datas,col);
                                table.setModel(model);
                            }
                            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                            JTableHeader header = table.getTableHeader();
                            header.setBackground(Color.yellow);
                            if(error!=null){
                                f.remove(error);
                            }
                            if(pane==null)
                              pane = new JScrollPane(table);
                            pane.setBounds(20,200,500,50);
                            f.add(pane);
                            f.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
                            f.repaint();

                        }



                    }
                    if(hit==false){
                        throw new Exception("Employee ID not Found");
                    }
                    }catch (Exception ex){
                    if(error==null)
                        error=new JLabel();

                    error.setText(ex.getMessage());
                    error.setBounds(60,250,400,30);
                    f.add(error);
                    f.repaint();


                }

            }
        });
        clear =new JButton("Clear");
        clear.setBounds(320,120,150,30);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idv.setText("");hoursv.setText("");f.remove(pane);
                if(error!=null){
                    f.remove(error);
                }
                f.repaint();
            }
        });


        f.add(id);f.add(hours);f.add(idv);f.add(hoursv);f.add(button);f.add(clear);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public  static  void  main(String [] args){
        GrossPay g = new GrossPay();
    }
}